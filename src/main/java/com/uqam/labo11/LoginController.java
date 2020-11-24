package com.uqam.labo11;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginForm(@RequestParam(name = "msg", required = false) String msg, Model model) {

		model.addAttribute("msg", msg);

		return "login";
	}

	@RequestMapping("/logout")
	public String logout(@RequestParam(name = "msg", required = false) String msg, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@PostMapping("/perform_login")

	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(username, password);
		AuthProvider authProvider = new AuthProvider();
		Authentication auth = authProvider.authenticate(userPass);
		System.out.println("Auth dans login " + auth);
		if (auth != null) {
			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);

			HttpSession ses = request.getSession(true);
			ses.setAttribute("SPRING_SECURITY_CONTEXT", sc);

			return "redirect:/";
		}

		model.addAttribute("msg", "Erreur username mode pass");

		return "redirect:/login";

	}

}