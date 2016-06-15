package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.order.service.PcIOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private PcIOrderService pcOrderService;
	
	@RequestMapping("/search")
	@ResponseBody
	public Map<String,Object> searchOrder(String requestId, String mqId, String keyWord, Integer startIndex, Integer pageSize){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> ret = pcOrderService.searchOrder(requestId, mqId, keyWord, startIndex, pageSize);
		
		retMap.put("ret",ret);
		
		return retMap;
		
		
	}
	
}
