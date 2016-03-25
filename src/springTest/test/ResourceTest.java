package springTest.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

public class ResourceTest {
	
	public static void main(String[] args) throws IOException{
		//ByteArrayResource
		Resource resource = new ByteArrayResource("hello deer".getBytes());
		if(resource.exists()){
			new ResourceTest().dumpStream(resource);
		}
		
		System.out.println(resource.isOpen());
		
		//InputStreamResource
		ByteArrayInputStream bis = new ByteArrayInputStream("hello young".getBytes());
		Resource resourceIS = new InputStreamResource(bis);
		if(resourceIS.exists()){
			new ResourceTest().dumpStream(resourceIS);
		}
		
		System.out.println(resourceIS.isOpen());
		
		//FileSystemResource
		File file = new File("E:/example/deer.txt");
		Resource rosourceFS = new FileSystemResource(file);
		if(rosourceFS.exists()){
			new ResourceTest().dumpStream(rosourceFS);
		}
		
		System.out.println(rosourceFS.isOpen());
		
		//ClassPathResource
		Resource resoourceCP = new ClassPathResource("test.xml");
		
		if(resoourceCP.exists()){
			new ResourceTest().dumpStream(resoourceCP);
		}
		System.out.println("path:"+resoourceCP.getFile().getAbsolutePath());
		System.out.println(resoourceCP.isOpen());
	}

	public void dumpStream(Resource resource){
		InputStream is = null;
		try {
			//获取文件资源
			is = resource.getInputStream();
			//读取资源
			byte[] descBytes = new byte[is.available()];
			is.read(descBytes);
			System.out.println(new String(descBytes));
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				//关闭资源
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
