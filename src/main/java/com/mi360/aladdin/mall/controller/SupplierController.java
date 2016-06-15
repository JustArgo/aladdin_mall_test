package com.mi360.aladdin.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.supplier.domain.Supplier;
import com.mi360.aladdin.supplier.service.ISupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping("/get")
	@ResponseBody
	public Supplier getSupplier(String requestId, Integer id){
		
		return supplierService.getSupplier(id, requestId);
		
	}
	
}
