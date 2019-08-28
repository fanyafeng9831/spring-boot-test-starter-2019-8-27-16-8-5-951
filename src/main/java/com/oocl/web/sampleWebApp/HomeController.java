package com.oocl.web.sampleWebApp;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
    @RequestMapping("/hello")
    public @ResponseBody String getHello() {
        return "Hello World";
    }
    @RequestMapping("/user")
    public @ResponseBody HashMap<String,String> userController(){
    	HashMap<String,String> map = new HashMap<String,String>();
    	map.put("user", "¿Ó“ª“ª");
    	return map;
    	
    }
}