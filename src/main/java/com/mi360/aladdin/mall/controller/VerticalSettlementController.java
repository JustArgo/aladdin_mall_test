package com.mi360.aladdin.mall.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.vertical.settlement.service.PcVerticalSettlementService;

@Controller
@RequestMapping("/vertical/settlement")
public class VerticalSettlementController {
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private PcVerticalSettlementService pcVerticalSettlementService;

	@RequestMapping("/findDailySales")
	@ResponseBody
	public Map<String, Object> countMemberAll(String requestId, String mqId, String startDate, String endDate)
			throws ParseException {
		return pcVerticalSettlementService.findDailySales(requestId, mqId, sdf.parse(startDate), sdf.parse(endDate));
	}

	@RequestMapping("/findDailyTopSales")
	@ResponseBody
	public Map<String, Object> findDailyTopSales(String requestId, String mqId, int num) {
		return pcVerticalSettlementService.findDailyTopSales(requestId, num);
	}
	
	@RequestMapping("/findSales")
	@ResponseBody
	public Map<String, Object> findSales(String requestId, String mqId, int page, int pageSize) {
		return pcVerticalSettlementService.findSales(requestId, mqId, page, pageSize);
	}
}
