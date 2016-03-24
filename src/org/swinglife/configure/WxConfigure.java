package org.swinglife.configure;

public class WxConfigure {
	
	//微信公众号AppId
	public static final String APPID = "wx45768611c53d9105";
	
	//微信商户号ID
	public static final String MCHID = "1264761301";
	
	//商户支付密钥
	public static final String APIKEY = "longkeysoft20150818youngdeermake";
	
	//微信公众号AppSecret
	public static final String APPSECRET = "97864afcca546fall3e32d7f16151f31";
	
	//HTTPS证书的本地路径
	public static String certLocalPath = "E:/ly_personal/微信相关文档/cert/apiclient_cert.p12";

	//HTTPS证书密码，默认密码等于商户号MCHID
	public static String certPassword = "1264761301";
	
	public static String HttpsRequestClassName = "org.swinglife.util.HttpsRequest";
	
	public static String unifiedOrder_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static String getCertLocalPath() {
		return certLocalPath;
	}

	public static void setCertLocalPath(String certLocalPath) {
		WxConfigure.certLocalPath = certLocalPath;
	}

	public static String getCertPassword() {
		return certPassword;
	}

	public static void setCertPassword(String certPassword) {
		WxConfigure.certPassword = certPassword;
	}

	public static String getAppid() {
		return APPID;
	}

	public static String getMchid() {
		return MCHID;
	}

	public static String getApikey() {
		return APIKEY;
	}

	public static String getAppsecret() {
		return APPSECRET;
	}

}
