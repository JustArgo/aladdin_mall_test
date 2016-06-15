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
@RequestMapping("/test")
public class TestController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private PcIOrderService pcOrderService;
	
	@Autowired
	private ServiceTestMapper serviceTestMapper;
	
	@Autowired
	private IShopCarService shopCarService;
	
	@Autowired
	private IProductVoService productVoService;
	
	
	/**
	 * 分页查询热销商品
	 * @return
	 */
	@RequestMapping("/product/hotsell")
	@ResponseBody
	public Map<String,Object> selectHotSellProduct(String requestId, Integer startIndex, Integer pageSize, String orderBy, String platform){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map> ret = productService.selectByKeyWordWithPaginationAddSupplier("", startIndex, pageSize, orderBy, platform, requestId);
		retMap.put("products", ret);
		
		return retMap;
		
	}
	
	@RequestMapping("/order/search")
	@ResponseBody
	public Map<String,Object> searchOrder(String requestId, String mqId, String keyWord, Integer startIndex, Integer pageSize){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		List<Map<String,Object>> ret = pcOrderService.searchOrder(requestId, mqId, keyWord, startIndex, pageSize);
		
		retMap.put("ret",ret);
		
		return retMap;
		
		
	}
	
	/**
	 * 添加到购物车
	 * @return
	 */
	@RequestMapping("/shopcar/add")
	@ResponseBody
	public Map<String, Object> addToShopCar(String requestId, String mqId, Integer productId, Integer skuId, Integer buyNum){
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		
		int ret = shopCarService.addToShopCar(mqId, productId, skuId, buyNum, requestId);
		
		retMap.put("ret", ret);
		List<ShopCarProduct> shopCarProducts = shopCarService.getShopCarProducts(mqId, requestId);
		retMap.put("result", shopCarProducts);
		
		return retMap;
		
	}
	
	@RequestMapping("/product/vo")
	@ResponseBody
	public ProductVo  getProductVo(String requestId, Integer productId){
		
		return productVoService.getProductVo(productId, requestId);
		
	}
	
	@RequestMapping("/product/sellcount")
	@ResponseBody
	public Integer productSellCount(String requestId, Integer productId, Integer year, Integer month, Integer day){
		
		return productService.selectSellCount(requestId, year, month, day, productId);
		
	}
		
	
	
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
	
	
}
