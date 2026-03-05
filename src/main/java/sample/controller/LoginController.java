package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sample.common.dao.entity.Login;
import sample.common.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	// ブラウザで「"/login"」にアクセスしたときに動く
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		Login user = loginService.authenticate(username, password);
		if (user != null) {
			return "redirect:/tasks";
		} else {
			model.addAttribute("error", "IDまたはパスワードが正しくありません");
			return "login";
		}
	}
}
