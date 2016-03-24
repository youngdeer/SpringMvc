package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {
	public static void main(String args[]){
		ObjectOutputStream objectWriter = null;
		ObjectInputStream objectReader = null;
		try {
			objectWriter = new ObjectOutputStream(new FileOutputStream("E:/example/student.txt"));
			objectWriter.writeObject(new Student("aa",11));
			objectWriter.writeObject(new Student("bb",22));
			objectWriter.writeObject(new Student("cc",33));
			objectReader = new ObjectInputStream(new FileInputStream("E:/example/student.txt"));
			for(int i = 0; i < 3; i++){
				try {
					System.out.println(objectReader.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				objectWriter.close();
				objectReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	static class Student implements Serializable{
		private String name;
		private int age;
		
		public Student(String name,int age){
			this.name = name;
			this.age = age;
		}
		
		@Override  
	   public String toString() {  
	      return "Student [name=" + name + ", age=" + age + "]";  
	   }  
	}
}
