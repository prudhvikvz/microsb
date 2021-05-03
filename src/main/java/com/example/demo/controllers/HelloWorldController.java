package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HelloBean;

@RestController			
public class HelloWorldController {

	@RequestMapping(method= RequestMethod.GET,path = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hellobean")
	public HelloBean helloBean() {
		return new HelloBean("Hello Bean");
	}
	@GetMapping(path = "/hellobean/pv/{name}")
	public HelloBean helloBean(@PathVariable String name) {
		return new HelloBean(String.format("Hello, %s",name));
	}
}
