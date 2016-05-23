package Nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	//FileChannel读取数据到Buffer
	public static void main(String[] args){
		try {
			RandomAccessFile aFile = new RandomAccessFile("E:/example/xiongmao.jpg","rw");
			FileChannel inChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while(bytesRead != -1){
				System.out.println("read: "+bytesRead);
				buf.flip();
				
				while(buf.hasRemaining()){
					System.out.println(buf.get());
				}
				
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
