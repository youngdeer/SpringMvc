package org.swinglife.form;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.swinglife.configure.WxConfigure;
import org.swinglife.util.RandomStringGenerator;
import org.swinglife.util.Signature;

public class UnifiedOrder {

	//统一下单传输参数
	private String appid = ""; //微信分配的公众账号ID（企业号corpid即为此appId） 
	private String mch_id = ""; //微信支付分配的商户号
	private String device_info = "WEB"; //终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	private String nonce_str = ""; //随机字符串，不长于32位。推荐随机数生成算法
	private String sign = ""; //签名，详见签名生成算法
	private String body = "Ipad mini  16G  白色"; //商品或支付单简要描述
	private String detail = ""; //商品名称明细列表
	private String attach = ""; //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	private String out_trade_no = "1217752501201407033233368018"; //商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	private String fee_type = ""; //符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	private String total_fee = "888"; //订单总金额，只能为整数，详见支付金额
	private String spbill_create_ip = "8.8.8.8"; //APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String time_start = ""; //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	private String time_expire = ""; //订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
	private String goods_tag = ""; //商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
	private String notify_url = "http://www.qq.com"; //接收微信支付异步通知回调地址
	private String trade_type = "JSAPI"; //取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
	private String product_id = ""; //trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	private String limit_pay = ""; //no_credit--指定不能使用信用卡支付
	private String openid = "oqms8t0I_8FD_Iq0UwikKxLz73LM"; //trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
	
	/**
	 * 统一下单构造方法
	 * @return
	 */
	public UnifiedOrder(){
		setAppid(WxConfigure.getAppid());
		setMch_id(WxConfigure.getMchid());
		setDevice_info(device_info);
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		//根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中 
	}
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mchId) {
		mch_id = mchId;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String deviceInfo) {
		device_info = deviceInfo;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonceStr) {
		nonce_str = nonceStr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
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
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String feeType) {
		fee_type = feeType;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbillCreateIp) {
		spbill_create_ip = spbillCreateIp;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String timeStart) {
		time_start = timeStart;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String timeExpire) {
		time_expire = timeExpire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goodsTag) {
		goods_tag = goodsTag;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notifyUrl) {
		notify_url = notifyUrl;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String tradeType) {
		trade_type = tradeType;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String productId) {
		product_id = productId;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limitPay) {
		limit_pay = limitPay;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
	public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
