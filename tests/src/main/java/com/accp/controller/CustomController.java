package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Custom;

import com.accp.service.CustomService;

@Controller
@RequestMapping("/CustomController")
public class CustomController {
	@Autowired
	CustomService service;
	@RequestMapping("/toIndex")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Custom findAll(Model model) {
		/*TbBill list=service.find();
		model.addAttribute("list", list);*/
		return service.find();
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(@RequestBody Custom list) {
		int i=service.insertsAndRemoves(list);
		if (i>0) {
			return "0000";
		}
		return "0001";
	}
	@RequestMapping("/findById")
	@ResponseBody
	public Custom findBybillno(int id) {
		return service.findBybillno(id);
	}
}
