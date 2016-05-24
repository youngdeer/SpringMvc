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
			int bytesRead = inChannel.read(buf); //read into buff
			while(bytesRead != -1){
				System.out.println("read: "+bytesRead);
				buf.flip(); //将buffer从写模式切换到读模式
				
				while(buf.hasRemaining()){
					System.out.println(buf.get());
				}
				
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
			
			RandomAccessFile toFile = new RandomAccessFile("E:/example/toFile.txt","rw");
			FileChannel toChannel = toFile.getChannel();
			String data = "new data by luyang "+System.currentTimeMillis();
			buf.clear();
			buf.put(data.getBytes());
			buf.flip();
			while(buf.hasRemaining()){
				toChannel.write(buf);
			}
			toChannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
