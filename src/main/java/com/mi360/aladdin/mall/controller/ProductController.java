package com.mi360.aladdin.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.comment.domain.Comment;
import com.mi360.aladdin.comment.service.ICommentService;
import com.mi360.aladdin.product.domain.ProductAttr;
import com.mi360.aladdin.product.domain.ProductAttrValue;
import com.mi360.aladdin.product.domain.ProductDetail;
import com.mi360.aladdin.product.service.IProductCollectService;
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
	
	@Autowired
	private IProductCollectService productCollectService;
	
	@Autowired
	private ICommentService commentService;
	
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
	
	/**
	 * 查询商品详情
	 * @param requestId
	 * @param productId
	 * @return
	 */
	@RequestMapping("/vo")
	@ResponseBody
	public ProductVo  getProductVo(String requestId, Integer productId){
		
		return productVoService.getProductVo(productId, requestId);
		
	}
	
	/**
	 * 收藏商品
	 * @param requestId
	 * @param mqId
	 * @param id
	 * @return
	 */
	@RequestMapping("/collect")
	@ResponseBody
	public int collectProduct(String requestId, String mqId, Integer id){
		
		return productService.collectProduct(mqId, id, requestId);
		
	}
	
	/**
	 * 查询商品有多少个规格 
	 * @param requestId
	 * @param id
	 * @return
	 */
	@RequestMapping("/get-attrs")
	@ResponseBody
	public List<ProductAttr> getProductAttrByProductID(String requestId, Integer id){
		
		return productService.getProductAttrByProductID(id, requestId);
		
	}
	
	/**
	 * 根据属性id查询 属性的可选值
	 * @param requestId
	 * @param attrId
	 * @return
	 */
	@RequestMapping("/get-attr-value")
	@ResponseBody
	public List<ProductAttrValue> getProductAttrValue(String requestId, Integer attrId){
		
		return productService.getAttrValuesByAttrID(attrId, requestId);
		
	}
	
	/**
	 * 查询是否已收藏该商品
	 * @param requestId
	 * @param mqId
	 * @param productId
	 * @return
	 */
	@RequestMapping("/isCollect")
	@ResponseBody
	public int isCollect(String requestId, String mqId, Integer productId){

		return productCollectService.isCollect(mqId, productId, requestId);
		
	}
	
	/**
	 * 查询商品 描述内容
	 * @param requestId
	 * @param productId
	 * @return
	 */
	@RequestMapping("/get-detail")
	@ResponseBody
	public ProductDetail getProductDetailByProductID(String requestId, Integer productId){
		
		return productService.getProductDetailByProductID(requestId, productId);
		
	}
	
	/**
	 * 查询我的收藏
	 * @param requestId
	 * @param mqId
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/get-product-collect")
	@ResponseBody
	public List<Map<String,Object>> getProductCollectListByMqID(String requestId, String mqId, Integer start, Integer pageSize){
		
		return productCollectService.getProductCollectListByMqID(mqId, start, pageSize, requestId);
		
	}
	
	/**
	 * 取消商品收藏
	 * @param requestId
	 * @param mqId
	 * @param productId
	 * @return
	 */
	@RequestMapping("/uncollect")
	@ResponseBody
	public int unCollect(String requestId, String mqId, Integer productId){
		return productService.uncollectProduct(mqId, productId, requestId);
	}
	
	/**
	 * 查询商品图片 有图 无图 
	 * @param requestId
	 * @param hasImage
	 * @param productId
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/comment/get")
	@ResponseBody
	public List<Comment> getCommentList(String requestId, Integer hasImage, Integer productId, Integer startIndex, Integer pageSize){
		
		return commentService.getComment(requestId, productId, hasImage, startIndex, pageSize);
		
	}
	
	
}
