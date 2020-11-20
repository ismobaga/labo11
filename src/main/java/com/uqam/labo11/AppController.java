package com.uqam.labo11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	@GetMapping("/")
	@ResponseBody
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		return "hello " + name;
	}
}
