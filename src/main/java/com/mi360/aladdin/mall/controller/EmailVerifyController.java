package com.mi360.aladdin.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.message.email.service.EmailVerifyService;

@Controller
@RequestMapping("/emailVerify")
public class EmailVerifyController {
	@Autowired
	private EmailVerifyService emailVerifyService;

	@RequestMapping("/send")
	@ResponseBody
	private Map<String, Object> send(String requestId, String type, String email) {
		return emailVerifyService.send(requestId, email, type);
	}
	
	@RequestMapping("/verify")
	@ResponseBody
	private Map<String, Object> verify(String requestId, String type, String email,String code) {
		return emailVerifyService.verify(requestId, email, code, type);
	}

}
