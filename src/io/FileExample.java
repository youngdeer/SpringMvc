package io;

import java.io.File;

public class FileExample {
	public static void main(String args[]){
		createFile();
	}
	
	
	public static void createFile(){
		File f = new File("E:/example/deer.txt");
		File f1 = new File("E:"+File.separator+"example");
		try{
			f.createNewFile();
			System.out.println("返回分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G");
			f.mkdir();
			//f.delete();
			System.out.println("文件名："+f.getName());
			System.out.println("父级目录："+f.getParent());
			
			//遍历目录下全部文件
			File[] listFile = f1.listFiles();
			for(File str : listFile){
				System.out.println(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
