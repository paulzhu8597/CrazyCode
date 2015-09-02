package com.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.util.Common;

@Controller
@RequestMapping("/report/")
public class ReportController {

	@RequestMapping("dayreport")
	public String dayreport(Model model){
		return Common.BACKGROUND_PATH + "/report/dayreport";
	}
	
	@RequestMapping("goprintpage")
	public String printpage(){
		return Common.BACKGROUND_PATH + "/report/printpage";
	}
	
}
