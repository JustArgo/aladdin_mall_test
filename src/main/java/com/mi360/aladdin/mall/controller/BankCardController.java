package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.unionpay.service.UnionpayService;

@Controller
@RequestMapping("/bankcard")
public class BankCardController {

	@Autowired
	private UnionpayService unionpayService;
	
	/**
	 * 新增银行卡
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Object> addBankCard(){
		
		Map<String,Object> retMap  = new HashMap<String,Object>();
		
		return retMap;
		
	}
	

}
