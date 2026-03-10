package sample.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	// ブラウザで「"/"」にアクセスしたときに動く
	@GetMapping("/")
	public String homePage() {
		return "homePage";
	}
}