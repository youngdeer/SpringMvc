package socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientWriteRead {

	public static void main(String[] args) throws UnknownHostException, IOException{
		String host = "127.0.0.1";
		int port = 1234;
		Socket client = new Socket(host,port); //于服务器端建立连接，然后写数据
		
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("hello server");
		writer.write("eof");
		writer.flush();  //只有flush之后服务端才能接收到数据
		
		Reader reader = new InputStreamReader(client.getInputStream());
		char chars[] = new char[64];
		int len;
		StringBuilder sb = new StringBuilder(); 
		while((len = reader.read(chars)) != -1){
			sb.append(new String(chars,0,len));
		}
		
		System.out.println("get Info from server: "+sb);
		reader.close();
		writer.close();
		client.close();
	}
}
