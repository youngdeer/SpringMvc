package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
	public static void main(String[] args){
		Member[] members = {new Member("aa",11),new Member("bb",22),new Member("cc",33)};
		try {
			DataOutputStream dataWriter = new DataOutputStream(new FileOutputStream(args[0]));
			for(Member member:members){
				dataWriter.writeUTF(member.getName());
				dataWriter.writeInt(member.getAge());
			}
			dataWriter.flush();
			dataWriter.close();
			DataInputStream dataReader = new DataInputStream(new FileInputStream(args[0]));
			for(int i = 0; i < members.length; i++){
				String name = dataReader.readUTF();
				int age = dataReader.readInt();
				members[i] = new Member(name,age);
			}
			dataReader.close();  
			   
	        for(Member member : members)  
	        {  
	           System.out.printf("%s\t%d%n",member.getName(),member.getAge());  
	        }  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


