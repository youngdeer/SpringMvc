package wechat.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wechat.weixinsdk.bean.EventMessage;
import wechat.weixinsdk.bean.xmlmessage.XMLMessage;
import wechat.weixinsdk.bean.xmlmessage.XMLTextMessage;
import wechat.weixinsdk.util.ExpireSet;
import wechat.weixinsdk.util.XMLConverUtil;

@Controller
public class InsertWeixinService{

	/**
	 * 微信接入
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("insertWeixin")
	public void inserWeixin(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
//		加密/校验流程如下：
//		1. 将token、timestamp、nonce三个参数进行字典序排序
//		2. 将三个参数字符串拼接成一个字符串进行sha1加密
//		3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		String echostr = req.getParameter("echostr");
		ServletOutputStream outputStream = res.getOutputStream();
		//建议做一步signature验证，验证步骤为上方文字描述
		if(echostr != null){
			outputStreamWrite(outputStream, echostr);
			outputStream.flush();
			return;
		}
		ServletInputStream inputStream = req.getInputStream();
		messageDeal(inputStream,outputStream);
	}
	
	private static ExpireSet<String> expireSet = new ExpireSet<String>(60);
	
	
	/**
	 * 微信消息处理
	 * @param inputStream
	 * @param outputStream
	 */
	public void messageDeal(ServletInputStream inputStream,ServletOutputStream outputStream){
		if (inputStream != null) {
			// 转换XML
			EventMessage eventMessage = null; 
			
			eventMessage = XMLConverUtil.convertToObject(EventMessage.class, inputStream);
			String expireKey = eventMessage.getFromUserName() + "__" + eventMessage.getToUserName() + "__" + eventMessage.getMsgId() + "__" + eventMessage.getCreateTime();
			
			String openId = eventMessage.getFromUserName();
			
			// 重复通知不作处理
			if (expireSet.contains(expireKey)) {
				return;
			} else {
				expireSet.add(expireKey);
			}

			// 创建回复
			XMLMessage xml = null; 
			if (eventMessage != null) {
				if("V103_SET".equals(eventMessage.getEventKey())){
					StringBuffer sb = new StringBuffer();
					sb.append("您好,欢迎关注我的测试号，DEER!\n");
					sb.append("<a href=\"http://q303565368.6655.la/SpringMvc/index.html?openId=" + openId + "\">我要绑定</a>\n");
					xml = new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), sb.toString());
				}else{
					StringBuffer sb = new StringBuffer();
					sb.append("您好,欢迎关注我的测试号，DEER!\n"); 
					xml = new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), sb.toString());
				}
			}
			if (xml!=null) {
				xml.outputStreamWrite(outputStream);
			}
			return;
		}
	}
	
	
	/**
	 * 输出流
	 * @param outputStream
	 * @param text
	 * @return
	 */
	private boolean outputStreamWrite(OutputStream outputStream, String text) {
		try {
			outputStream.write(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
			return false;
		} catch (IOException e) { 
			e.printStackTrace();
			return false;
		}
		return true;
	} 
}
