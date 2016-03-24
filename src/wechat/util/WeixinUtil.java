package wechat.util;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import wechat.configure.WxConfigure;

import wechat.weixinsdk.api.TokenAPI;
import wechat.weixinsdk.bean.Token;

@SuppressWarnings("unchecked")
public class WeixinUtil {
	
	private static Map tokens = new Hashtable();
	

	/**
	 * 获取token
	 * @return
	 */
	public static String getToken(){
		String token = (String)tokens.get("token");
        try
        {
            Date dt = (Date)tokens.get("time");
            if(dt == null || System.currentTimeMillis() - dt.getTime() > 3600000L)
            {
                token = (new TokenAPI()).token(WxConfigure.APPID,WxConfigure.APPSECRET).getAccess_token();
                dt = new Date();
                tokens.put("token", token);
                tokens.put("time", dt);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return token;
	}
	
	/**
	 * 根据网页授权code获取openId
	 * @param code
	 * @return
	 */
	public static String getOpenIdByCode(String code)
    {
        Token token = (new TokenAPI()).token(WxConfigure.APPID, WxConfigure.APPSECRET, code);
        return token.getOpenid();
    }
}
