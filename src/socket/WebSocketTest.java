package socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketTest {

	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException{
		System.out.println("Receive : "+message);
		session.getBasicRemote().sendText("this is the first message.");
		
		int sendMessages = 0;
		while(sendMessages < 3){
			Thread.sleep(5000);
			session.getBasicRemote().
	        sendText("This is an intermediate server message. Count: "+ sendMessages);
			sendMessages++;
		}
		
		session.getBasicRemote().sendText("this is the last message.");
	}
	
	@OnOpen
	public void onOpen(){
		System.out.println("client open");
	}
	
	@OnClose
	public void onClose(){
		System.out.println("connect close");
	}
}
