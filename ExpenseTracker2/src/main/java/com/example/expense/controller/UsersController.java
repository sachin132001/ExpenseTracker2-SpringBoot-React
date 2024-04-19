package com.example.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.LoginData;
import com.example.expense.entity.Users;
import com.example.expense.services.UsersService;
import com.example.expense.services.UsersServiceImplementation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@CrossOrigin("*")
@RestController
public class UsersController {
	@Autowired
	UsersService userv;
	
	@PostMapping("/register")
	public String addUsers(@RequestBody   Users u) {
		boolean status=userv.emailExists(u.getEmail());
		if(status==false) {
			userv.addUsers(u);
			return "login";
		}else {
			return "register";
		}
		
		
	}
	
	@PostMapping("/login")
	public String validateUsers(@RequestBody LoginData data, HttpSession session) {
	    if (userv.validateUsers(data.getUserOrPass(), data.getPassword())) {
	        session.setAttribute("userOrPass", data.getUserOrPass());
	        return "home";
	    } else {
	        return "login";
	    }
	}

	
	 @PostMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // Invalidate the session
	        return "login"; // Redirect to login page
	    }

}
