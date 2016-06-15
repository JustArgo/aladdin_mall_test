package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.mall.domain.ServiceTest;
import com.mi360.aladdin.mall.mapper.ServiceTestMapper;
import com.mi360.aladdin.order.service.PcIOrderService;
import com.mi360.aladdin.product.service.IProductService;
import com.mi360.aladdin.product.service.IProductVoService;
import com.mi360.aladdin.product.vo.ProductVo;
import com.mi360.aladdin.shopcar.domain.ShopCarProduct;
import com.mi360.aladdin.shopcar.service.IShopCarService;


@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private ServiceTestMapper serviceTestMapper;
	
	
	@RequestMapping("/prepare")
	@ResponseBody
	public Map<String,Object> prepare(String requestId){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> allService = serviceTestMapper.selectAllService();
		
		retMap.put("services", allService);
		
		return retMap;
		
	}
	
	@RequestMapping("/find-by-service-code")
	@ResponseBody
	public List<ServiceTest> findByServiceCode(String requestId, String serviceCode){
		
		return serviceTestMapper.selectByServiceCode(serviceCode);
		
	}
	
	@RequestMapping("/add-method")
	public String add(String requestId, String methodName, String methodUrl, String paramData, String serviceName, String serviceCode){
		
		ServiceTest serviceTest = new ServiceTest();
		serviceTest.setMethodName(methodName);
		serviceTest.setMethodUrl(methodUrl);
		serviceTest.setParamData(paramData);
		serviceTest.setServiceCode(serviceCode);
		serviceTest.setServiceName(serviceName);
		
		serviceTestMapper.insertSelective(serviceTest);
		
		return "home";
		
	}
	
}
