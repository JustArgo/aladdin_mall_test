package com.mi360.aladdin.mall;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.json.JSON;
import com.mi360.aladdin.mall.domain.ServiceTest;
import com.mi360.aladdin.mall.mapper.ServiceTestMapper;

public class Start {

	public static void main(String[] args) throws Exception{
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		
		ServiceTestMapper mapper = context.getBean(ServiceTestMapper.class);
		
		ServiceTest serviceTest = new ServiceTest();
		
		serviceTest.setID(null);
		serviceTest.setMethodName("查询供应商");
		serviceTest.setMethodUrl("/supplier/get");
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",335);
		
		serviceTest.setParamData(JSON.json(param));
		serviceTest.setServiceCode("supplier");
		serviceTest.setServiceName("供应商服务");
		mapper.insertSelective(serviceTest);
		
	}
	
}
