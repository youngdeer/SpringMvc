package org.swinglife.form;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.swinglife.configure.WxConfigure;
import org.swinglife.util.RandomStringGenerator;
import org.swinglife.util.Signature;

public class UnifiedOrder {

	//ͳһ�µ��������
	private String appid = ""; //΢�ŷ���Ĺ����˺�ID����ҵ��corpid��Ϊ��appId�� 
	private String mch_id = ""; //΢��֧��������̻���
	private String device_info = "WEB"; //�ն��豸��(�ŵ�Ż������豸ID)��ע�⣺PC��ҳ���ں���֧���봫"WEB"
	private String nonce_str = ""; //����ַ�����������32λ���Ƽ�����������㷨
	private String sign = ""; //ǩ�������ǩ�������㷨
	private String body = "Ipad mini  16G  ��ɫ"; //��Ʒ��֧������Ҫ����
	private String detail = ""; //��Ʒ������ϸ�б�
	private String attach = ""; //�������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ����ֶ���Ҫ�����̻�Я���������Զ�������
	private String out_trade_no = "1217752501201407033233368018"; //�̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ, ����˵�����̻�������
	private String fee_type = ""; //����ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY������ֵ�б������������
	private String total_fee = "888"; //�����ܽ�ֻ��Ϊ���������֧�����
	private String spbill_create_ip = "8.8.8.8"; //APP����ҳ֧���ύ�û���ip��Native֧�������΢��֧��API�Ļ���IP��
	private String time_start = ""; //��������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010���������ʱ�����
	private String time_expire = ""; //����ʧЧʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��27��9��10��10���ʾΪ20091227091010���������ʱ�����
	private String goods_tag = ""; //��Ʒ��ǣ�����ȯ�������Żݹ��ܵĲ�����˵���������ȯ�������Ż�
	private String notify_url = "http://www.qq.com"; //����΢��֧���첽֪ͨ�ص���ַ
	private String trade_type = "JSAPI"; //ȡֵ���£�JSAPI��NATIVE��APP��WAP,��ϸ˵���������涨
	private String product_id = ""; //trade_type=NATIVE���˲����ش�����idΪ��ά���а�������ƷID���̻����ж��塣
	private String limit_pay = ""; //no_credit--ָ������ʹ�����ÿ�֧��
	private String openid = "oqms8t0I_8FD_Iq0UwikKxLz73LM"; //trade_type=JSAPI���˲����ش����û����̻�appid�µ�Ψһ��ʶ���µ�ǰ��Ҫ���á���ҳ��Ȩ��ȡ�û���Ϣ���ӿڻ�ȡ���û���Openid����ҵ����ʹ�á���ҵ��OAuth2.0�ӿڡ���ȡ��ҵ���ڳ�Աuserid���ٵ��á���ҵ��useridתopenid�ӿڡ�����ת��
	
	/**
	 * ͳһ�µ����췽��
	 * @return
	 */
	public UnifiedOrder(){
		setAppid(WxConfigure.getAppid());
		setMch_id(WxConfigure.getMchid());
		setDevice_info(device_info);
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		//����API����ǩ���������ǩ��
        String sign = Signature.getSign(toMap());
        setSign(sign);//��ǩ���������õ�Sign��������� 
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
