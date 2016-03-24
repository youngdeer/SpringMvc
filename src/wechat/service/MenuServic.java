package wechat.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wechat.configure.WxConfigure;
import wechat.util.WeixinUtil;
import wechat.weixinsdk.api.MenuAPI;
import wechat.weixinsdk.bean.BaseResult;
import wechat.weixinsdk.bean.MenuButtons;
import wechat.weixinsdk.bean.MenuButtons.Button;

@Controller
public class MenuServic {

	/**
	 * 微信公众号按钮生成
	 */
	@RequestMapping("menuCreate")
	public void menuCreate(){
		//获取token
		String token = WeixinUtil.getToken();
		
		//构建微信菜单
		MenuAPI menuAPI = new MenuAPI();
		menuAPI.menuDelete(token);
		
		MenuButtons menuButtons = new MenuButtons();
		Button[] btns = new Button[3];
		btns[0] = new Button();
		btns[0].setType("view");
		btns[0].setName("进进货订单");
		btns[0].setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxConfigure.APPID+"&redirect_uri=http://q303565368.6655.la/SpringMvc/index.html&response_type=code&scope=snsapi_base#wechat_redirect");

		btns[1] = new Button();
		btns[1].setType("view");
		btns[1].setName("进进货消息");
		btns[1].setUrl("https://www.baidu.com/");
//		btns[1].setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+netPath+"system/pubmodule/anon/weixin/oauth2/"+custId+"/toMessage.do&response_type=code&scope=snsapi_base#wechat_redirect");

		
		btns[2] = new Button();
		btns[2].setType("click");
		btns[2].setName("绑定");
		btns[2].setKey("V103_SET");

		menuButtons.setButton(btns);
		BaseResult bs = menuAPI.menuCreate(token, menuButtons);

		if ("0".equals(bs.getErrcode())) {
			System.out.println("-----------create menu success----------");
		}else{
			System.out.println(bs.getErrcode()+"---"+bs.getErrmsg());
		}
	}
}
