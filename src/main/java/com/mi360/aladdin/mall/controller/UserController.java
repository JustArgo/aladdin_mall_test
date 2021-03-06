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
	
	@RequestMapping("/findSimpleUserInfo")
	@ResponseBody
	public Map<String, Object> findSimpleUserInfo(String requestId, String mqId) {
		return pcUserService.findSimpleUserInfo(requestId, mqId);
	}

	@RequestMapping("/createPc")
	@ResponseBody
	public Map<String, Object> createPc(String requestId,Integer ivLuckNum, String password, String phone, String email) {
		return pcUserService.createPc(requestId,ivLuckNum, password, phone, email);
	}

	@RequestMapping("/existEmail")
	@ResponseBody
	public Map<String, Object> existEmail(String requestId, String email) {
		return pcUserService.existEmail(requestId, email);
	}

	@RequestMapping("/existPaymentPassword")
	@ResponseBody
	public Map<String, Object> existPaymentPassword(String requestId, String mqId) {
		return pcUserService.existPaymentPassword(requestId, mqId);
	}

	@RequestMapping("/existPhone")
	@ResponseBody
	public Map<String, Object> existPhone(String requestId, String phone) {
		return pcUserService.existPhone(requestId, phone);
	}

	@RequestMapping("/loginAuthentication")
	@ResponseBody
	public Map<String, Object> loginAuthentication(String requestId, String password, String mqId, String phone, String email) {
		return pcUserService.loginAuthentication(requestId, password, mqId, phone, email);
	}

	@RequestMapping("/modifyLoginPassword")
	@ResponseBody
	public Map<String, Object> modifyLoginPassword(String requestId, String mqId, String password,
			String prePassword) {
		return pcUserService.modifyLoginPassword(requestId, mqId, prePassword, password);
	}

	@RequestMapping("/modifyPaymentPassword")
	@ResponseBody
	public Map<String, Object> modifyPaymentPassword(String requestId, String mqId, String password,
			String prePassword) {
		return pcUserService.modifyPaymentPassword(requestId, mqId, prePassword, password);
	}

	@RequestMapping("/registerActivation")
	@ResponseBody
	public Map<String, Object> registerActivation(String requestId, String mqId) {
		return pcUserService.registerActivation(requestId, mqId);
	}

	@RequestMapping("/savePc")
	@ResponseBody
	public Map<String, Object> savePc(String requestId, String mqId, String headImage, String nickname, Integer sex) {
		return pcUserService.savePc(requestId, mqId, headImage, nickname, sex);
	}

}
