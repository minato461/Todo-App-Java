package sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sample.common.dao.entity.Task;
import sample.common.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	// ブラウザで「"/tasks"」にアクセスしたときに動く（タスク一覧画面の表示）
	@GetMapping("/tasks")
	public String listTasks(Model model) {
		List<Task> tasks = taskService.findAll();
		model.addAttribute("tasks",tasks);
		return "tasks/list";
	}
	
	// タスク登録画面の表示
	@GetMapping("/tasks/new")
	public String showCreateForm(Model model) {
		model.addAttribute("task", new Task());
		return "tasks/form-new";
	}
	
	// タスク登録画面の実行
		@PostMapping("/tasks")
		public String createTask(Task task) {
			taskService.insert(task);
			return "redirect/tasks";
		}
}
