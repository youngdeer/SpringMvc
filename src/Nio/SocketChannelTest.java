package Nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {

	public static void main(String[] args){
		try {
			SocketChannel socketChannel = SocketChannel.open();
//			socketChannel.configureBlocking(false);
			System.out.println(InetAddress.getByName("192.168.3.61"));
			socketChannel.connect(new InetSocketAddress("192.168.3.61",80));
			
			ByteBuffer buf = ByteBuffer.allocate(48);
			int byteRead = socketChannel.read(buf);
			while(byteRead != -1){
				System.out.println("-----------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
