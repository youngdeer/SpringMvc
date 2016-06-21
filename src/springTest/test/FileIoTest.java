package springTest.test;

import io.GetHtml;

public class FileIoTest {

	
	
	public static void main(String[] args){
		GetHtml getHtml = new GetHtml();
		System.out.println(getHtml.getHtml("WebRoot/page/websocket.html"));
	}
}
