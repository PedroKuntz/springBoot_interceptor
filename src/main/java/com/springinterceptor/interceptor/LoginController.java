package com.springinterceptor.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping("/user/list")
	public @ResponseBody List<String> getAllUserAuth() {
		List<String> usersAuth = new ArrayList<String>();
		usersAuth.add("adm0");
		usersAuth.add("adm1");
		usersAuth.add("adm2");
		usersAuth.add("adm3");
		usersAuth.add("adm4");
		usersAuth.add("adm5");
		usersAuth.add("adm6");
		usersAuth.add("adm7");
		usersAuth.add("adm8");
		return usersAuth; 
	}	
	
	@PostMapping("/login")
	public @ResponseBody String login(@RequestParam String user, HttpSession session) {
		if(user.equals("adm")) {
			session.setAttribute("user.login", user);
			return "Usuario Logado: " + user;
		}
		return "Usuario Inválido";
	}
	
}
