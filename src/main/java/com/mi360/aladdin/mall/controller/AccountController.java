package com.mi360.aladdin.mall.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.account.service.PcAccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private PcAccountService pcAccountService;

	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/getAccountDetailByDate")
	@ResponseBody
	public Map<String, Object> getAccountDetailByDate(String requestId, String mqId, String accountType,
			String startDate, String endDate, int page, int pageSize) throws Exception {
		return pcAccountService.getAccountDetailByDate(requestId, mqId, accountType, sdf.parse(startDate),
				sdf.parse(endDate), page, pageSize);
	}

	@RequestMapping("/getAccountInfo")
	@ResponseBody
	public Map<String, Object> getAccountInfo(String requestId, String mqId) {
		return pcAccountService.getAccountInfo(requestId, mqId);
	}

	@RequestMapping("/getRemainingSum")
	@ResponseBody
	public Map<String, Object> getRemainingSum(String requestId, String mqId) {
		return pcAccountService.getRemainingSum(requestId, mqId);
	}

	@RequestMapping("/applyOfflineRecharge")
	@ResponseBody
	public Map<String, Object> applyOfflineRecharge(String requestId, String mqId, int luckNum, long sum,
			String externalOrderId, String externalOrderTime, String phone, String remark) throws ParseException {
		return pcAccountService.applyOfflineRecharge(requestId, mqId, luckNum, sum, externalOrderId, sdf.parse(externalOrderTime),
				phone, remark);
	}

}
