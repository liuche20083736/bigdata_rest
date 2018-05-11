package com.bigdata.service;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bigdata.dao.impala.QueryMapper;
import com.bigdata.dao.impala.User;
import com.bigdata.vo.zchj.ZCHJ_Image_Input;
import com.bigdata.vo.zchj.ZCHJ_Image_Output;
import com.bigdata.vo.zchj.ZCHJ_Query_Input;
import com.bigdata.vo.zchj.ZCHJ_Query_Output;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ZCHJ_Service {

	  @Autowired
	  private RestTemplate restTemplate;
	  
	  @Resource
	  QueryMapper userMapper;
	  
	
	  public ZCHJ_Image_Output getHbaseImage(ZCHJ_Image_Input zchj_Image_Input) {
	        String url = "http://bigdata2:20550//"+zchj_Image_Input.getTable()+"//"+zchj_Image_Input.getKey(); 
	        System.out.println(url);
//	         postData = new JSONObject(); 
	        
//	        try {
//				postData.put();
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//	        JSONObject json = restTemplate.getForEntity(url,JSONObject.class).getBody();
	        String output_String = restTemplate.getForObject(url, String.class);
	        output_String = output_String.replace("\"Row\"", "\"row\"").replace("\"Cell\"", "\"cell\"").replace("\"$\"", "\"value\"");
//	        zchj_Image_Output.getRow();
	        System.out.println(output_String);
	        ObjectMapper mapper = new ObjectMapper();
	        ZCHJ_Image_Output zchj_Image_Output = null;
			try {
				zchj_Image_Output = mapper.readValue(output_String, ZCHJ_Image_Output.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return zchj_Image_Output;
	  }
	  
	  public Object getImpalaQuery(ZCHJ_Query_Input zchj_Query_Input) {
//		  User user = userMapper.selectByUsername("admin");
		  String sql ="select * from user a left join plane b on a.id = b.planename";
		  List<HashMap<String, Object>> oject = userMapper.superManagerSelect(zchj_Query_Input.getSql());
//		  System.out.println(user.getPassword());  
		  return oject;
	  }
	  
}
