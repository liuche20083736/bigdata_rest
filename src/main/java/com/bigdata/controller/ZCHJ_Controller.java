package com.bigdata.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.service.ZCHJ_Service;
import com.bigdata.vo.zchj.ZCHJ_Image_Input;
import com.bigdata.vo.zchj.ZCHJ_Image_Output;
import com.bigdata.vo.zchj.ZCHJ_Query_Input;
import com.bigdata.vo.zchj.ZCHJ_Query_Output;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * 
 */
@RestController
public class ZCHJ_Controller {
	public static String USER_KEY ="userid" ;
	
//	@Resource
//	LoginService loginService;
//	
//	@Resource
//	PiccpWebClient webClient;
//	
//	@Resource
//	PiccpQueryService queryService;
//	
//	@Resource
//	PiccpFormService formService;
	
	@Resource
	ZCHJ_Service ZCHJ_service;
	
    /**
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws FailingHttpStatusCodeException 
     * 
     */
	@RequestMapping(path ="/image" , method = RequestMethod.POST)
	@ResponseBody
    public Object image(@RequestBody ZCHJ_Image_Input zchj_Image_Input) {
		System.out.println(zchj_Image_Input.getKey());
		ZCHJ_Image_Output zchj_Image_output=ZCHJ_service.getHbaseImage(zchj_Image_Input);
		return zchj_Image_output;
		//have
//		boolean flag = loginService.login(uservo);
//		if(flag==true) {
//			request.getSession().setAttribute(USER_KEY, uservo);
//			return uservo;
//		}else {
//			return null;
//		}		
    }
	
	@RequestMapping(path ="/query" , method = RequestMethod.POST)
	@ResponseBody
    public Object image(@RequestBody ZCHJ_Query_Input zchj_Query_Input) {
		System.out.println(zchj_Query_Input.getSql());
		Object object=ZCHJ_service.getImpalaQuery(zchj_Query_Input);
		return object;
		//have
//		boolean flag = loginService.login(uservo);
//		if(flag==true) {
//			request.getSession().setAttribute(USER_KEY, uservo);
//			return uservo;
//		}else {
//			return null;
//		}		
    }


}