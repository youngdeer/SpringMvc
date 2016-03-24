package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String args[]){
		byte[] buffer = new byte[512];
		int numberRead = 0;
		FileInputStream input = null;
		FileOutputStream output = null;
		try{
			input = new FileInputStream("E:/example/xiongmao.jpg");
			output = new FileOutputStream("E:/example/xiongmao2.jpg");
			while((numberRead = input.read(buffer)) != -1){
				output.write(buffer, 0, numberRead);
			}
		}catch(final IOException e){
			e.printStackTrace();
		}finally{
			try{
				input.close();
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
