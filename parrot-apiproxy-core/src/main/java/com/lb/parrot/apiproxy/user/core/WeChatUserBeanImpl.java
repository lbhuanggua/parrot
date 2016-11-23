package com.lb.parrot.apiproxy.user.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lb.parrot.apiproxy.support.api.WeChatAccessTokenBean;
import com.lb.parrot.apiproxy.user.api.WeChatUserBean;
import com.lb.parrot.support.WeChatClient;
import com.lb.parrot.support.WeChatConnector;
import com.lb.parrot.support.WeChatContext;
import com.lb.parrot.support.bean.WeChatContextDefault;
import com.lb.parrot.support.common.ToServerResult;
import com.lb.parrot.support.common.WeChatErrMsg;
import com.lb.parrot.support.convert.ConvertMode;
import com.lb.parrot.support.exception.WeChatUserException;
import com.lb.parrot.support.result.ErrorResult;
import com.lb.parrot.support.result.Oauth2Token;
import com.lb.parrot.support.result.UserInfoResult;
import com.lb.parrot.support.url.GetAuthOauth2TokenUrl;
import com.lb.parrot.support.url.GetOauth2TokenUrl;
import com.lb.parrot.support.url.GetRefreshOauth2TokenUrl;
import com.lb.parrot.support.url.GetUserInfoHtmlUrl;
import com.lb.parrot.support.url.GetUserInfoUrl;
import com.lb.parrot.support.util.ParserUtil;
import com.lb.parrot.support.util.StringUtil;

@Service("weChatUserBean")
public class WeChatUserBeanImpl implements WeChatUserBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatUserBeanImpl.class);
	
	@Autowired
	WeChatConnector weChatConnector;
	
	@Autowired
	WeChatClient weChatClient;
	
	@Autowired
	WeChatAccessTokenBean weChatAccessTokenBean;

	@Override
	public UserInfoResult getUserInfoHtml(String code)  throws WeChatUserException{
		//TODO 此接口内部实现需优化
		LOGGER.debug("用户管理：接收微信推送参数，code = {}", code);
		UserInfoResult result = null;
		try {
			if (StringUtil.isEmpty(code))
				throw new WeChatUserException("code is null");
			//第二步：通过code换取网页授权access_token
			GetOauth2TokenUrl getOauth2TokenUrl = new GetOauth2TokenUrl(weChatClient.getAppid(), weChatClient.getSecret(), code);
			WeChatContext oauth2TokenContext = new WeChatContextDefault();
			weChatConnector.send(getOauth2TokenUrl, oauth2TokenContext);
			Oauth2Token oauth2Token = JSON.parseObject((String) oauth2TokenContext.getOutput(), Oauth2Token.class);
			LOGGER.debug("用户管理：通过code换取网页授权Oauth2Token = {}", oauth2Token.toString());
			if(!StringUtil.isEmpty(oauth2Token.getErrCode())){
				throw new WeChatUserException(oauth2Token.getErrCode(), oauth2Token.getErrMsg());
			}else {
				LOGGER.debug("用户管理：网页授权access_token 校验前, openid={}, accessToken={}", oauth2Token.getOpenId(), oauth2Token.getAccessToken());
				//附：检验授权凭证（access_token）是否有效
				GetAuthOauth2TokenUrl getAuthOauth2TokenUrl = new GetAuthOauth2TokenUrl(oauth2Token.getAccessToken(), oauth2Token.getOpenId());
				WeChatContext authOauth2TokenContext = new WeChatContextDefault();
				weChatConnector.send(getAuthOauth2TokenUrl, authOauth2TokenContext);
				ErrorResult errorResult = JSON.parseObject((String)authOauth2TokenContext.getOutput(), ErrorResult.class);
				LOGGER.debug("用户管理：检验授权凭证（access_token）是否有效,errcode={}, errmsg={}", errorResult.getErrCode(), errorResult.getErrMsg());
				//第三步：刷新access_token（如果需要）
				if(!errorResult.getErrCode().equalsIgnoreCase("0")){
					GetRefreshOauth2TokenUrl getRefreshOauth2TokenUrl = new GetRefreshOauth2TokenUrl(weChatClient.getAppid(), oauth2Token.getRefreshToken());
					WeChatContext refreshOauth2Token = new WeChatContextDefault();
					weChatConnector.send(getRefreshOauth2TokenUrl, refreshOauth2Token);
					oauth2Token = JSON.parseObject((String)refreshOauth2Token.getOutput(), Oauth2Token.class);
					LOGGER.debug("用户管理：刷新Oauth2Token = {}", oauth2Token.toString());
				}
				//LOGGER.debug("网页授权access_token 校验后, openid={},accessToken={}", oauth2Token.getOpenId(), oauth2Token.getAccessToken());
				//第四步：拉取用户信息(需scope为 snsapi_userinfo)
				GetUserInfoHtmlUrl getUserInfoUrl = new GetUserInfoHtmlUrl(oauth2Token.getAccessToken(), oauth2Token.getOpenId());
				WeChatContext userInfoContext = new WeChatContextDefault();
				weChatConnector.send(getUserInfoUrl, userInfoContext);
				LOGGER.debug("用户管理：拉取用户信息  = {}", userInfoContext.getOutput().toString());
				result = JSON.parseObject((String)userInfoContext.getOutput(), UserInfoResult.class);
				LOGGER.debug("用户管理：解析用户信息  = {}", result);
				if(!StringUtil.isEmpty(oauth2Token.getErrCode())){
					throw new WeChatUserException(oauth2Token.getErrCode(), oauth2Token.getErrMsg());
				}
			}
		}catch(WeChatUserException e){
			LOGGER.error("errcode={}, errmsg={}, errmsgzh_CN={}", e.getErrorCode(), e.getMessage(), WeChatErrMsg.getErrmsgCN(Integer.parseInt(e.getErrorCode())), e);
			throw e;
		}
		return result;
	}

	@Override
	public UserInfoResult getUserInfo(String openId) throws WeChatUserException{
		LOGGER.debug("用户管理>>>接收open_id：{}", openId);
		String accessToken = weChatAccessTokenBean.getAccessToken().getAccessToken();
		GetUserInfoUrl toUrl = new GetUserInfoUrl(accessToken, openId);
		WeChatContext context = new WeChatContextDefault();
		weChatConnector.send(toUrl, context);
		LOGGER.debug("用户管理>>>接收微信反馈表单：{}", (String) context.getOutput().toString());
		ToServerResult toServerResult = ParserUtil.parse((String)context.getOutput(), ConvertMode.SEND);
		if (toServerResult instanceof ErrorResult) {
			ErrorResult errorResult = (ErrorResult) toServerResult;
			LOGGER.error("用户管理>>>出错：code:{}, msg：{}", errorResult.getErrCode(), errorResult.getErrMsg());
			throw new WeChatUserException(errorResult.getErrCode(), errorResult.getErrMsg());
		}
		return (UserInfoResult) toServerResult;
	}
	
}
