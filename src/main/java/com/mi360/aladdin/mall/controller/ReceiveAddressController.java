package com.mi360.aladdin.mall.controller;

import java.util.List;

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
	
	
	
}
