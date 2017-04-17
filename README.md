# parrot -微信公众号应用开发组件
 当然你也可以把它当作接入微信公众号应用开发的入门示例
## 项目简介

实现以下组件和服务
* AccessToken中控服务
* API-Proxy代理服务
* 基于Spring框架的可插拔式消息处理模块

参考微信开放平台建议框架图如下：
![wechat](http://mmbiz.qpic.cn/mmbiz_png/PiajxSqBRaEIQxibpLbyuSK9XkjDgZoL0xnC7SUbrIRwI8NhEGFeax6HoPcTMDqKGYxaSoNqBwocrj70Pt1EcKnQ/0?wx_fmt=png)

## 所需环境
* Java 1.8
* Maven 3.5

## 安装使用
 * 克隆项目：git clone https://github.com/lbhuanggua/parrot.git  
 * 进入项目目录：cd parrot
 * 编译项目：mvn clean install
### AccessToken中控服务安装
 * 启动：java -jar parrot-token\target\parrot-token-0.0.2-SNAPSHOT.jar --spring.profiles.active=prod --server.port=#{port} --logging.path=#{log.path} --parrot.wechat.appid=#{appid} --parrot.wechat.secret=#{secret}
 * #{port}=应用端口（默认8001）
 * #{log.path}=日志路径
 * #{appid}=微信公众号应用ID
 * #{secret}=微信公众号应用密钥
#### 接口使用
* 获取AccessToken
访问地址：http://localhost:8001/access_token/
返回数据如下：
```json
 {
  "errCode": null,
  "errMsg": null,
  "accessToken": "OHXTTpf9eyau63pdsUFtmXQBPx7P4qBhDiltJ93b52vcoOKggZXc_zToN-Ys1sRDCRubHj1FUYs2zIN4DxCIJOs6beUpj0oguePV0tGh-KmHWBGHcduG3-21meL1X72uZJZbAFAGQG",
  "expiresIn": 7200
}
```
* 获取JsTicket
访问地址：http://localhost:8001/js_ticket/
返回数据如下：
```json
{
  "errCode": "0",
  "errMsg": "ok",
  "ticket": "kgt8ON7yVITDhtdwci0qeVF22qH7_onrrjRcc8LEqd0odfGQsFl2oxPIFHhGzgAx0_80OPOlG-tlcz_3xntdlQ",
  "expiresIn": 7200
}
```
* 获取JsSignature
访问地址：http://localhost:8001/js_signature?url=#{url}
返回数据如下：
```json
{
  "appId": "wx7c18d34b1d06b8a4",
  "timestamp": 1492423873,
  "nonceStr": "HbfyZeTHnwkiSljG",
  "signature": "d6fd895f21b0f0c1556980b2d619e9b0d4a01871",
  "url": "url"
}
```
### API-Proxy代理服务安装
 * 启动：java -jar parrot-apiproxy-boot\target\parrot-apiproxy-boot-0.0.2-SNAPSHOT.jar --spring.profiles.active=prod --server.port=#{port} --logging.path=#{log.path} --parrot.wechat.appid=#{appid} --parrot.wechat.secret=#{secret} --parrot.wechat.token=#{token} --parrot.wechat.encodeAseKey=#{encodeAseKey} --parrot.wechat.mchId=#{mchId} --parrot.wechat.payToken=#{payToken} --parrot.wechat.checkSignature=#{checkSignature} --parrot.wechat.checkIp=#{checkIp} --parrot.wechat.certType=#{certType} --parrot.wechat.certPath=#{certPath} --parrot.wechat.password=#{password}
 * #{port}=应用端口（默认8002）
 * #{log.path}=日志路径
 * #{appid}=微信公众号应用ID
 * #{secret}=微信公众号应用密钥
 * #{token}=Token(令牌)
 * #{encodeAseKey}=消息加解密密钥
 * #{mchId}=商户号
 * #{payToken}=商户平台的PAY_Token字符串
 * #{checkSignature}=是否强制检查签名(true or false) 
 * #{checkIp}=是否检查微信服务器ip(true or false) 
 * #{certType}=证书类型(pkcs12),详情查看https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
 * #{certPath}=证书路径
 * #{password}=证书密码
#### 接口使用
* 自定义菜单
* 消息管理
* 素材管理
* 用户管理
* 账号管理
* 数据统计
* 微信支付
## 历史版本
## 待实现功能
## 沟通交流
+ 请扫微信二维码:

	<img src="wechat.jpg" width="200">


