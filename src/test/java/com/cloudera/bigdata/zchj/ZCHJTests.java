package com.cloudera.bigdata.zchj;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bigdata.vo.zchj.ZCHJ_Image_Input;
import com.bigdata.vo.zchj.ZCHJ_Image_Output;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ZCHJTests {
	
	static private Logger log = LoggerFactory.getLogger(ZCHJTests.class);

	@Autowired
	private RestTemplate restTemplate; 
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test  
	   public void threadTest() throws Throwable {  
		 testWriteImage("1111",new Random().nextInt(100)+".bmp");
		
		
	       // 构造一个Runner  
//	       TestRunnable runner = new TestRunnable() {  
//	           @Override  
//	           public void runTest() throws Throwable {  
//	               // 测试内容  
//	               System.out.println(Thread.currentThread().getName());  
//	               testWriteImage("2222",new Random().nextInt(100)+".bmp");
//	           }  
//	       };  
//	       int runnerCount = 20;  
//	       // Rnner数组，想当于并发多少个。  
//	       TestRunnable[] trs = new TestRunnable[runnerCount];  
//	       for (int i = 0; i < runnerCount; i++) {  
//	           trs[i] = runner;  
//	       }  
//	       // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入  
//	       MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);  
//	       // 开发并发执行数组里定义的内容  
//	       mttr.runTestRunnables();  
		
	   } 
	
	
	public void testWriteImage(String key,String filename) {
		String url = "http://localhost:8080/image";  
		ZCHJ_Image_Input zchj_Image_Input = new ZCHJ_Image_Input();
		zchj_Image_Input.setKey(key);
		ZCHJ_Image_Output zchj_Image_Output = restTemplate.postForObject(url, zchj_Image_Input, ZCHJ_Image_Output.class);
		String value = zchj_Image_Output.getRow().get(0).getCell().get(0).value;
		byte[] bytevalue = null;
		try {
			bytevalue = Base64.decodeBase64(value);
//			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "D:\\test\\"+filename;
		FileImageOutputStream imageOutput = null;
		try {
			imageOutput = new FileImageOutputStream(new File(path ));
			imageOutput.write(bytevalue, 0, bytevalue.length);
			imageOutput.flush();
			imageOutput.close();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
