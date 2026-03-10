package sample.thymeleaf.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import sample.common.dao.entity.Login;
import sample.common.dao.entity.Task;
import sample.common.dao.mapper.LoginMapper;
import sample.common.service.LoginService;
import sample.common.service.TaskService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private LoginMapper loginMapper;
	
	// ブラウザで「"/login"」にアクセスしたときに動く
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(
			@RequestParam String username,
			@RequestParam String password,
			HttpSession session,
			Model model) {
		Login user = loginService.authenticate(username, password);
		if (user != null) {
			session.setAttribute("user", user); 
			return "redirect:/tasks";
		} else {
			model.addAttribute("error", "IDまたはパスワードが正しくありません");
			return "login";
		}
	}
	
	// 登録画面の表示
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password) {
		loginMapper.insertUser(username, password);
		return "redirect:/login";
	}
	
	// APIの設定
	@PostMapping("/api/login")
	@ResponseBody
	public List<Task> apiLogin(@RequestBody Login loginRequest, HttpSession session) {
		Login user = loginService.authenticate
				(loginRequest.getUsername(), loginRequest.getPassword());
		
		if (user != null) {
			session.setAttribute("user", user);
			return taskService.findAllByUsername(user.getUsername());
		} else {
			return null;
		}
	}
	
}
