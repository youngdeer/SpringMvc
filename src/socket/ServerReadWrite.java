package socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReadWrite {

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
		String temp;
		int index;
		while((len = reader.read(chars)) != -1){
			temp = new String(chars,0,len);
			if((index = temp.indexOf("eof")) != -1){ //当读取数据遇到eof时结束接收
				sb.append(temp.substring(0, index));
				break;
			}
			sb.append(temp);
		}
		
		//只有上面循环结束之后下面代码才会继续执行
		
		System.out.println("get Info: "+sb);
		
		Writer writer = new OutputStreamWriter(socket.getOutputStream());
		writer.write("hello client!");
		writer.flush();
		writer.close();
		reader.close();
		socket.close();
		server.close();
	}
}
