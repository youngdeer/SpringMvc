package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioServer {

	//定义selector
	private Selector selector = null;
	static final int PORT = 30000;
	
	private Charset charset = Charset.forName("UTF-8");
	
	public void init() throws IOException{
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",PORT);
		server.socket().bind(isa);
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		while(selector.select() > 0){
			for(SelectionKey key:selector.selectedKeys()){
				selector.selectedKeys().remove(key);
				//如果key对应的channel包含了客户端的请求
				if(key.isAcceptable()){
					//调用accept方法接收链接，产生服务器端channel
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
				}
				//如果key对应的channel有数据要读
				if(key.isReadable()){
					SocketChannel sc = (SocketChannel) key.channel();
					ByteBuffer buf = ByteBuffer.allocate(1024);
					String content = "";
					//开始都数据
					while(sc.read(buf) > 0){
						buf.flip();
						content += charset.decode(buf);
					}
					System.out.println("读取到的数据： "+content);
					//将Key对应的channel设置为准备下一次读取
					key.interestOps(SelectionKey.OP_READ);
					
					if(content.length() > 0){
						for(SelectionKey skey:selector.selectedKeys()){
							Channel targetChannel = skey.channel();
							//如果该channel是SocketChannel，九江读取到得内容写入该channel里去
							if(targetChannel instanceof SocketChannel){
								SocketChannel dest = (SocketChannel) targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		new NioServer().init();
	}
}
