package com.mi360.aladdin.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi360.aladdin.user.service.PcUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private PcUserService pcUserService;

	@RequestMapping("/createPc")
	@ResponseBody
	private Map<String, Object> createPc(String requestId, String password, String phone, String email) {
		return pcUserService.createPc(requestId, password, phone, email);
	}

	@RequestMapping("/createPc")
	@ResponseBody
	private Map<String, Object> createPc(String requestId, String email) {
		return pcUserService.existEmail(requestId, email);
	}

	@RequestMapping("/existPaymentPassword")
	@ResponseBody
	private Map<String, Object> existPaymentPassword(String requestId, String mqId) {
		return pcUserService.existPaymentPassword(requestId, mqId);
	}

	@RequestMapping("/existPhone")
	@ResponseBody
	private Map<String, Object> existPhone(String requestId, String phone) {
		return pcUserService.existPhone(requestId, phone);
	}

	@RequestMapping("/loginAuthentication")
	@ResponseBody
	private Map<String, Object> createPc(String requestId, String password, String mqId, String phone, String email) {
		return pcUserService.loginAuthentication(requestId, password, mqId, phone, email);
	}

	@RequestMapping("/modifyLoginPassword")
	@ResponseBody
	private Map<String, Object> modifyLoginPassword(String requestId, String mqId, String password,
			String prePassword) {
		return pcUserService.modifyLoginPassword(requestId, mqId, prePassword, password);
	}

	@RequestMapping("/createPc")
	@ResponseBody
	private Map<String, Object> modifyPaymentPassword(String requestId, String mqId, String password,
			String prePassword) {
		return pcUserService.modifyPaymentPassword(requestId, mqId, prePassword, password);
	}

	@RequestMapping("/createPc")
	@ResponseBody
	private Map<String, Object> registerActivation(String requestId, String mqId) {
		return pcUserService.registerActivation(requestId, mqId);
	}

	@RequestMapping("/createPc")
	@ResponseBody
	private Map<String, Object> savePc(String requestId, String mqId, String headImage, String nickname, Integer sex) {
		return pcUserService.savePc(requestId, mqId, headImage, nickname, sex);
	}

}
