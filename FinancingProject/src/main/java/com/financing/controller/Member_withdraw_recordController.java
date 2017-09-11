package com.financing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.financing.service.Member_withdraw_record_service;

@Controller
@RequestMapping("/Member_withdraw_recordController")
public class Member_withdraw_recordController {

		@Autowired
		private Member_withdraw_record_service mwrs;
		
		
}
