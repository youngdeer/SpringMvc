package org.swinglife.configure;

public class WxConfigure {
	
	//΢�Ź��ں�AppId
	public static final String APPID = "wx45768611c53d9105";
	
	//΢���̻���ID
	public static final String MCHID = "1264761301";
	
	//�̻�֧����Կ
	public static final String APIKEY = "longkeysoft20150818youngdeermake";
	
	//΢�Ź��ں�AppSecret
	public static final String APPSECRET = "97864afcca546fall3e32d7f16151f31";
	
	//HTTPS֤��ı���·��
	public static String certLocalPath = "E:/ly_personal/΢������ĵ�/cert/apiclient_cert.p12";

	//HTTPS֤�����룬Ĭ����������̻���MCHID
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
