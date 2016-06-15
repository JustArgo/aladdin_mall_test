package com.mi360.aladdin.mall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mi360.aladdin.mall.domain.ServiceTest;
import com.mi360.aladdin.mall.mapper.ServiceTestMapper;

public class Start {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();
		
		ServiceTestMapper mapper = context.getBean(ServiceTestMapper.class);
		
		ServiceTest serviceTest = new ServiceTest();
		
		serviceTest.setMethodName("查询商品详情");
		serviceTest.setMethodUrl("/test/product/vo");
		serviceTest.setParamData("{\"productId\":338}");
		serviceTest.setServiceCode("product");
		serviceTest.setServiceName("商品服务");
		
		mapper.insertSelective(serviceTest);
		
		serviceTest.setID(null);
		serviceTest.setMethodName("查询商品销量");
		serviceTest.setMethodUrl("/test/product/sellcount");
		serviceTest.setParamData("{productId:338,year:2016,month:6,day:13}");
		serviceTest.setServiceCode("product");
		serviceTest.setServiceName("商品服务");
		
	}
	
}
