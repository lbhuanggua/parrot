package com.lb.parrot.pay.message;

import com.lb.parrot.pay.common.AbstactPaySignature;
import com.lb.parrot.support.common.ToServerMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <p>
 * 统一下单表单
 * </p>
 * <p>
 * 详细参数说明，请前往https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1查看
 * </p>
 * 
 * @author lbhuanggua
 *
 */
public class UnifiedOrderMessage extends AbstactPaySignature implements
		ToServerMessage {
	private static final long serialVersionUID = 1L;
	/**
	 * 公众账号ID
	 */
	@XStreamAlias("appid")
	private String appId;

	/**
	 * 商户号
	 */
	@XStreamAlias("mch_id")
	private String mchId;

	/**
	 * 设备号
	 */
	@XStreamAlias("device_info")
	private String deviceInfo;

	/**
	 * 随机字符串
	 */
	@XStreamAlias("nonce_str")
	private String nonceStr;

	/**
	 * 签名
	 */
	@XStreamAlias("sign")
	private String signature;

	/**
	 * 商品简要描述，限制32个字符
	 */
	@XStreamAlias("body")
	private String body;

	/**
	 * 商品详细描述，限制8192个字符
	 */
	@XStreamAlias("detail")
	private String detail;

	/**
	 * 附加数据
	 */
	@XStreamAlias("attach")
	private String attach;

	/**
	 * 商品订单号
	 */
	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	/**
	 * 货币类型
	 */
	@XStreamAlias("fee_type")
	private String feeType;

	/**
	 * 总金额，单位为分
	 */
	@XStreamAlias("total_fee")
	private int totalFee;

	/**
	 * 终端IP
	 */
	@XStreamAlias("spbill_create_ip")
	private String spbillCreateIp;

	/**
	 * 订单生成时间，格式为yyyyMMddHHmmss
	 */
	@XStreamAlias("time_start")
	private String timeStart;

	/**
	 * 订单失效时间，格式为yyyyMMddHHmmss
	 */
	@XStreamAlias("time_expire")
	private String timeExpire;

	/**
	 * 商品标记
	 */
	@XStreamAlias("goods_tag")
	private String goodsTag;

	/**
	 * 回调URL地址
	 */
	@XStreamAlias("notify_url")
	private String notifyUrl;

	/**
	 * 交易类型
	 */
	@XStreamAlias("trade_type")
	private String tradeType;

	/**
	 * 商品Id
	 */
	@XStreamAlias("product_id")
	private String productId;

	/**
	 * 限定支付方式
	 */
	@XStreamAlias("limit_pay")
	private String limitPay;

	/**
	 * 微信用户id
	 */
	@XStreamAlias("openid")
	private String openId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
