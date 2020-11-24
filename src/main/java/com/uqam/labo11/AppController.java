package com.uqam.labo11;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uqam.labo11.model.AppDAO;
import com.uqam.labo11.model.User;

@Controller
public class AppController {
	private AppDAO appDAO = new AppDAO();

	@RequestMapping("/")
	public String index(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		System.out.println("Auth dans / " + auth);
		if (auth != null) {

			AppDAO appDAO = new AppDAO();
			User user = appDAO.getUser(auth.getName());
			model.addAttribute("user", user);
		}

		return "index";
	}

	@RequestMapping(value = "/denied")
	public String denied() {
		return "denied";
	}

	@RequestMapping(value = "/userPage")
	public String userPage(final Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = appDAO.getUser(auth.getName());

		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping(value = "/adminPage")
	public String adminPage(final Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = appDAO.getUser(auth.getName());

		model.addAttribute("user", user);
		return "user";
	}

	@GetMapping("/users")
	public String getUsers(HttpServletRequest request, final Model model) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			List<User> users = appDAO.getUsers();

			System.out.println(users);
			model.addAttribute("users", users);
			return "users";
		}
		return "redirect:/denied";

	}
}
