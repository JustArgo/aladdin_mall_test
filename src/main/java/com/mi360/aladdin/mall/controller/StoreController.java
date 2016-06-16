package com.mi360.aladdin.mall.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.store.service.IStoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private IStoreService storeService;

	@RequestMapping("/create")
	@ResponseBody
	public Map<String,Object> createStore(String requestId, String mqId, String title, String logoPath, String abstraction){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		int ret = storeService.createStore(requestId, mqId, title, logoPath, abstraction);
		
		retMap.put("ret", ret);
		retMap.put("store", storeService.getStore(requestId, mqId));
		
		return retMap;
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> updateStore(String requestId, String mqId, String title, String abstraction, String logoPath){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		int ret = storeService.updateStoreInfo(requestId, mqId, title, abstraction, logoPath);
		retMap.put("ret",ret);		
		
		retMap.put("store", storeService.getStore(requestId, mqId));
		
		return retMap;
	
	}
	
	@RequestMapping("/add-product")
	@ResponseBody
	public int addProductsIntoStore(String requestId, String mqId, Integer[] productIds){
		
		return storeService.addProductsIntoStore(requestId, mqId, productIds);
		
	}
	
	@RequestMapping("/del-product")
	@ResponseBody
	public int delProductsFromStore(String requestId, String mqId, Integer[] productIds){
		return storeService.delProductsFromStore(requestId, mqId, productIds);
	}
	
	@RequestMapping("/top-product")
	@ResponseBody
	public int topProductInStore(String requestId, String mqId, Integer productId){
		return storeService.topProductInStore(requestId, mqId, productId);
	}
	
	@RequestMapping("/recommend")
	@ResponseBody
	public int recommendProducts(String requestId, String mqId, Integer[] productIds){
		return storeService.recommendProducts(requestId, mqId, productIds);
	}
	
	@RequestMapping("/get-order-count")
	@ResponseBody
	public int getOrderCount(String requestId, String mqId, String startTime, String endTime) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return storeService.getOrderCount(requestId, mqId, format.parse(startTime), format.parse(endTime));
	}
	
	@RequestMapping("/get-order")
	@ResponseBody
	public List<Map<String,Object>> getOrder(String requestId, String mqId, String startTime, String endTime) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return storeService.getOrder(requestId, mqId, format.parse(startTime), format.parse(endTime));
	}
	
	@RequestMapping("/get-income-calc")
	@ResponseBody
	public List<Map<String,Object>> getIncomeCalc(String requestId, String mqId, String startTime, String endTime, Integer startIndex, Integer pageSize) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return storeService.getIncomeCalc(requestId, mqId, format.parse(startTime), format.parse(endTime), startIndex, pageSize);
	}
	
	@RequestMapping("/select-nopay-order")
	@ResponseBody
	public List<Map<String,Object>> selectNoPayedOrder(String requestId, String mqId, Integer startIndex, Integer pageSize){
		return storeService.selectNoPayedOrder(requestId, mqId, startIndex, pageSize);
	}
	
	@RequestMapping("/select-nosend-order")
	@ResponseBody
	public List<Map<String,Object>> selectNoSendOrder(String requestId, String mqId, Integer startIndex, Integer pageSize){
		return storeService.selectNoSendOrder(requestId, mqId, startIndex, pageSize);
	}
	
	@RequestMapping("/select-nocomment-list")
	@ResponseBody
	public List<Map<String,Object>> selectWaitForCommentList(String requestId, String mqId, Integer pageIndex, Integer pageSize){
		return storeService.selectWaitForCommentList(requestId, mqId, pageIndex, pageSize);
	}
	
	@RequestMapping("/select-returnmoney-list")
	@ResponseBody
	public List<Map<String,Object>> selectReturnMoneyList(String requestId, String mqId, Integer startIndex, Integer pageSize){
		return storeService.selectReturnMoneyList(requestId, mqId, startIndex, pageSize);
	}
	
	@RequestMapping("/select-returngoods-list")
	@ResponseBody
	public List<Map<String,Object>> selectReturnGoodsList(String requestId, String mqId, Integer pageIndex, Integer pageSize){
		return storeService.selectReturnGoodsList(requestId, mqId, pageIndex, pageSize);
	}
	
	
}
