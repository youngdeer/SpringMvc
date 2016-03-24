package wechat.weixinsdk.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import wechat.weixinsdk.bean.Token;
import wechat.weixinsdk.client.JsonResponseHandler;


public class TokenAPI extends BaseAPI{

	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public Token token(String appid,String secret){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/cgi-bin/token")
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Token.class));
	}
	
	
	public Token token(String appid,String secret,String code){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/access_token")
				.addParameter("grant_type","authorization_code")
				.addParameter("appid", appid)
				.addParameter("code", code)
				.addParameter("secret", secret)
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Token.class));
	}

}
