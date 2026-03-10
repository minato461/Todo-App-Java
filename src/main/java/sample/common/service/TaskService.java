package sample.common.service;

import java.util.List;

import sample.common.dao.entity.Task;

public interface TaskService {
	// 全件取得
	List<Task> findAllByUsername(String username);
	// 新規登録
	void insert(Task task);
	Long getNextId();
	Task findById(Long id);
	void update(Task task);
	void delete(Long id);
}