package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.product.service.IProductService;
import com.mi360.aladdin.product.service.IProductVoService;
import com.mi360.aladdin.product.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductVoService productVoService;
	
	/**
	 * 分页查询热销商品
	 * @return
	 */
	@RequestMapping("/hotsell")
	@ResponseBody
	public Map<String,Object> selectHotSellProduct(String requestId, Integer startIndex, Integer pageSize, String orderBy, String platform){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map> ret = productService.selectByKeyWordWithPaginationAddSupplier("", startIndex, pageSize, orderBy, platform, requestId);
		retMap.put("products", ret);
		
		return retMap;
		
	}
	
	@RequestMapping("/vo")
	@ResponseBody
	public ProductVo  getProductVo(String requestId, Integer productId){
		
		return productVoService.getProductVo(productId, requestId);
		
	}
	
	
}
