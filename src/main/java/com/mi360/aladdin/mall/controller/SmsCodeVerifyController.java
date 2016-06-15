package com.mi360.aladdin.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.message.sms.service.SmsCodeVerifyService;

@Controller
@RequestMapping("/emailVerify")
public class SmsCodeVerifyController {
	@Autowired
	private SmsCodeVerifyService smsCodeVerifyService;

	@RequestMapping("/send")
	@ResponseBody
	private Map<String, Object> send(String requestId, String type, String email) {
		return smsCodeVerifyService.send(requestId, email, type);
	}

	@RequestMapping("/verify")
	@ResponseBody
	private Map<String, Object> verify(String requestId, String type, String email, String code) {
		return smsCodeVerifyService.verify(requestId, email, code, type);
	}
}
