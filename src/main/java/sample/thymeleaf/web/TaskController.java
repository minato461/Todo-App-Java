package sample.thymeleaf.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import sample.common.dao.entity.Login;
import sample.common.dao.entity.Task;
import sample.common.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	// ブラウザで「"/tasks"」にアクセスしたときに動く（タスク一覧画面の表示）
	@GetMapping("/tasks")
	public String listTasks(HttpSession session, Model model) {
		Login user = (Login) session.getAttribute("user");
		List<Task> tasks = taskService.findAllByUsername(user.getUsername());
		model.addAttribute("tasks", tasks);
		return "tasks/list";
    }
	
	// タスク登録画面の表示
	@GetMapping("/tasks/new")
	public String showCreateForm(Model model) {
		Task task = new Task();
		task.setId(taskService.getNextId());
		model.addAttribute("task", task);
		return "tasks/form-new";
	}
	
	// タスク登録画面の実行
	@PostMapping("/tasks")
	public String create(@ModelAttribute Task task, HttpSession session) {
		Login loginUser = (Login) session.getAttribute("user");
		if (loginUser == null) {
			return "redirect:/login";
		}
		task.setUsername(loginUser.getUsername());
		taskService.insert(task);
		return "redirect:/tasks";
	}
	
	// 編集画面の表示
	@GetMapping("/tasks/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Task task = taskService.findById(id);
		model.addAttribute("task", task);
		return "tasks/form-edit";
	}
	
	// 更新の実行
	@PostMapping("/tasks/update/{id}")
	public String updateTask(@PathVariable Long id, Task task) {
		task.setId(id);
		taskService.update(task);
		return "redirect:/tasks";
	}
	
	// 削除の実行
	@PostMapping("/tasks/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.delete(id);
		return "redirect:/tasks";
	}
	
	// APIでのログインボタン設定
	@GetMapping("/api/tasks")
	@ResponseBody
	public List<Task> listTasksApi(HttpSession session) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ArrayList<>();
		}
		return taskService.findAllByUsername(username);
	}
	
}
