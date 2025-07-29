package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		System.out.println("Greeting request received with name: " + name);
		return "greeting";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(name="hovaten", required=false, defaultValue="Ho va ten") String hovaten, Model model) {
		model.addAttribute("name", hovaten);
		System.out.println("Hello request received with name: " + hovaten);
		return "greeting";
	}

}
