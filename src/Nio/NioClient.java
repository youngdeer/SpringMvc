package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NioClient {

	//定义selector
	private Selector selector = null;
	static final int PORT = 30000;
	
	private Charset charset = Charset.forName("UTF-8");
	private SocketChannel sc = null;
	
	public void init() throws IOException{
		selector = Selector.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",PORT);
		sc = SocketChannel.open(isa);
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		
		new ClientThread().start();
		//创建键盘输入流  
        Scanner scan=new Scanner(System.in);  
        while(scan.hasNextLine()){
        	System.out.println("--------------------");
            //读取键盘的输入  
            String line=scan.nextLine();  
            //将键盘的内容输出到SocketChanenel中  
            sc.write(charset.encode(line));  
        }  
	}
	
	//定义读取服务器端的线程
	private class ClientThread extends Thread{
		
		public void run(){
			try {
				while(selector.select() > 0){
					for(SelectionKey key: selector.selectedKeys()){
						selector.selectedKeys().remove(key);
						if(key.isReadable()){
							SocketChannel sc = (SocketChannel) key.channel();
							String content = "";
							ByteBuffer buf = ByteBuffer.allocate(1048);
							while(sc.read(buf) > 0){
								sc.read(buf);
								buf.flip();
								content += charset.decode(buf);
							}
							System.out.println("聊天内容： "+content);
							//将Key对应的channel设置为准备下一次读取
							key.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		new NioClient().init();
	}
}
