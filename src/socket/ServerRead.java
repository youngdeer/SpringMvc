package socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRead {

	//模拟服务器端读数据
	public static void main(String[] args) throws IOException{
		int port = 1234;
		//定义serversocket
		ServerSocket server = new ServerSocket(port);
		//server在尝试接收其他socket的请求，server的accept方法是阻塞的
		Socket socket = server.accept();
		//连接建立之后就可以从socket中获取inputStream，并从中获取信息
		
		Reader reader = new InputStreamReader(socket.getInputStream());
		char chars[] = new char[64];
		int len;
		StringBuilder sb = new StringBuilder(); 
		while((len = reader.read(chars)) != -1){
			sb.append(new String(chars,0,len));
		}
		
		System.out.println("get Info: "+sb);
		reader.close();
		socket.close();
		server.close();
	}
}
