package com.mi360.aladdin.mall.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.entity.order.Order;
import com.mi360.aladdin.order.service.IOrderService;
import com.mi360.aladdin.order.service.PcIOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private PcIOrderService pcOrderService;
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/search")
	@ResponseBody
	public Map<String,Object> searchOrder(String requestId, String mqId, String keyWord, Integer startIndex, Integer pageSize){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> ret = pcOrderService.searchOrder(requestId, mqId, keyWord, startIndex, pageSize);
		
		retMap.put("ret",ret);
		
		return retMap;
		
		
	}
	
	@RequestMapping("/place-order-store")
	@ResponseBody
	public Order placeOrderFromStore(String requestID, String mqID, String orderType, Integer[] skuIDs, Integer[] buyNums, Long pFee, Long pSum, String invoiceName, Integer invoiceID, String notes, Integer receaddID){
		System.out.println("mqID:"+mqID+" orderType:"+orderType+" skuIDs:"+Arrays.toString(skuIDs)+" buyNums:"+Arrays.toString(buyNums)+" pFee:"+pFee+" pSum:"+pSum+" invoiceName:"+invoiceName+" invoiceID:"+invoiceID+" notes:"+notes+" receaddID:"+receaddID);
		String orderCode = pcOrderService.placeOrderFromStore(mqID, orderType, skuIDs, buyNums, pFee, pSum, invoiceName, invoiceID, notes, receaddID, requestID);
		System.out.println("orderCode:"+orderCode);
		Order order = orderService.getOrderByOrderCode(orderCode, requestID);
		return order;
	}
	
	
	
}
