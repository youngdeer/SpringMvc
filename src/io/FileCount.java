package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCount {
	public static void main(String args[]){
		int count = 0;
		InputStream streamReader = null;
		try {
			streamReader = new FileInputStream(new File("E:/example/deer.txt"));
			while(streamReader.read() != -1){
				count++;
			}
			System.out.println("--文件长度："+count+"字节");
		} catch (final IOException e) {
			e.printStackTrace();
		}finally{
			try{
				streamReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
