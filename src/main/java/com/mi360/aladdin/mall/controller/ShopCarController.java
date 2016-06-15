package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.shopcar.domain.ShopCarProduct;
import com.mi360.aladdin.shopcar.service.IShopCarService;

@Controller
@RequestMapping("/shopcar")
public class ShopCarController {

	@Autowired
	private IShopCarService shopCarService;
	
	/**
	 * 添加到购物车
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> addToShopCar(String requestId, String mqId, Integer productId, Integer skuId, Integer buyNum){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		int ret = shopCarService.addToShopCar(mqId, productId, skuId, buyNum, requestId);
		
		retMap.put("ret", ret);
		List<ShopCarProduct> shopCarProducts = shopCarService.getShopCarProducts(mqId, requestId);
		retMap.put("result", shopCarProducts);
		
		return retMap;
		
	}
	
	
}
