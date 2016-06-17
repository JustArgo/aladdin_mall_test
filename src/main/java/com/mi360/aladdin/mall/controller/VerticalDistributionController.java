package com.mi360.aladdin.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.vertical.distribution.service.PcVerticalDistributionService;

@Controller
@RequestMapping("/vertical/distribution")
public class VerticalDistributionController {
	@Autowired
	private PcVerticalDistributionService pcVerticalDistributionService;

	@RequestMapping("/countMemberAll")
	@ResponseBody
	public Map<String, Object> countMemberAll(String requestId, String mqId) {
		return pcVerticalDistributionService.countMemberAll(requestId, mqId);
	}

	@RequestMapping("/findDirectlyMember")
	@ResponseBody
	public Map<String, Object> findDirectlyMember(String requestId, String mqId) {
		return pcVerticalDistributionService.findDirectlyMember(requestId, mqId, false, null, null);
	}

}
