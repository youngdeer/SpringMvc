package Nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransferTest {

	public static void main(String[] args){
		try {
			RandomAccessFile fromFile = new RandomAccessFile("E:/example/fromFile.txt","rw");
			FileChannel fromChannel = fromFile.getChannel();
			
			RandomAccessFile toFile = new RandomAccessFile("E:/example/toFile.txt","rw");
			FileChannel toChannel = toFile.getChannel();
			
			long position = 0;
			long count = fromChannel.size();
			
//			toChannel.transferFrom(fromChannel, position, count);
			fromChannel.transferTo(position, count, toChannel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
