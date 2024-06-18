package com.grupo11tpc.tpc.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
	public String loginCheck(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails.getAuthorities().stream()
            .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN")) ? 
            ViewRouteHelper.PRODUCT_INDEX : ViewRouteHelper.PRODUCT_SALE_INDEX;
    }
}
