package com.andy.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	private static boolean solved = false;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping(value="/tryCode", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="password") String password) {
		if("bushido".equals(password)) {
			solved = true;
			return "redirect:/code";
		} else {
			return "redirect:/createError";
		}
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	@RequestMapping("/code")
	public String displayCode() {
		if(solved == false) {
			return "redirect:/";
		} else {
			return "code";
		}
	}
}
