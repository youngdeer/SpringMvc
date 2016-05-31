package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiConnect {

	public static void main(String[] args) throws IOException{
		int port = 1234;
		//定义serversocket
		ServerSocket server = new ServerSocket(port);
		//server在尝试接收其他socket的请求，server的accept方法是阻塞的
		while(true){ //无限循环获取server是否准备好连接
			Socket socket = server.accept(); //连接建立之后就可以从socket中获取inputStream，并从中获取信息
			
			new Thread(new Task(socket)).start(); //采用多线程进行异步处理多个客户端访问
		}
		
	}
	
	/**
	 * 处理socket请求
	 */
	static class Task implements Runnable{

		private Socket socket;

		public Task(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				handleSocket();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 处理与client通信的socket
		 * @throws IOException 
		 */
		private void handleSocket() throws IOException{
//			使用BufferedReader，readLine()方法是阻塞的，当遇到换行符合或对应流结束符才会读取下一行
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
//	         StringBuilder sb = new StringBuilder();  
//	         String temp;  
//	         int index;  
//	         while ((temp=br.readLine()) != null) {  
//	            System.out.println(temp);  
//	            if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
//	             sb.append(temp.substring(0, index));  
//	                break;  
//	            }  
//	            sb.append(temp);  
//	         }  
			
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
		}
	}
	
	
}
