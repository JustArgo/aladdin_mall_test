package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.receadd.domain.ReceiveAddress;
import com.mi360.aladdin.receadd.service.IManageReceAddService;

@Controller
@RequestMapping("/receadd")
public class ReceiveAddressController {

	@Autowired
	private IManageReceAddService manageReceAddService;
	
	@RequestMapping("/usable-address")
	@ResponseBody
	public List<ReceiveAddress> listUableAddress(String requestId, String mqId){
		
		return manageReceAddService.listUsableAddress(mqId, requestId);
		
	}
	
	@RequestMapping("/set-default")
	@ResponseBody
	public int setUserDefaultAddress(String requestId, String mqId, Integer id,String isDefault){
		
		return manageReceAddService.setUserDefaultAddress(mqId, id, isDefault, requestId);
		
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public int addAddress(String requestId, ReceiveAddress address){
		
		return manageReceAddService.addAddress(address, requestId);
		
	}
	
	
	/**
	 * 删除收货地址
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delAddress(String requestId, Integer receaddId){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		int ret = manageReceAddService.deleteAddress(receaddId, requestId);
		retMap.put("ret", ret);
		
		String mqId = "d9afefcc54ec4a2ca6ca099e8cbd2413";
		
		retMap.put("receadd", manageReceAddService.listUsableAddress(mqId, requestId));
		
		return retMap;
		
	}
	
	/**
	 * 修改收货地址
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> updateAddress(String requestId, ReceiveAddress address){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		int ret = manageReceAddService.updateAddress(address, requestId);
		retMap.put("ret", ret);
		
		retMap.put("receadd-after-update", manageReceAddService.getAddress(address.getID(), requestId));
		
		
		return retMap;
		
	}
	
	
}
