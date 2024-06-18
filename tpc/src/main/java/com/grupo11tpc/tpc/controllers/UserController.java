package com.grupo11tpc.tpc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo11tpc.tpc.helpers.ViewRouteHelper;

@Controller
public class UserController {
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/loginsuccess")
	public String loginCheck() {
		//Para que cuando el usuario inicie sesion vaya al apartado de productos
		return ViewRouteHelper.PRODUCT_SALE_INDEX;
	}
}
