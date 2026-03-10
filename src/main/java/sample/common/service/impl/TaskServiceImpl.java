package sample.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.common.dao.entity.Task;
import sample.common.dao.mapper.TaskMapper;
import sample.common.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskMapper taskMapper;
	
	@Override
	public List<Task> findAllByUsername(String username) {
		return taskMapper.findAllByUsername(username);
	}
	
	@Override
	public void insert(Task task) {
		taskMapper.insert(task);
	}
	
	@Override
	public Long getNextId() {
		return taskMapper.selectNextId();
	}
	
	@Override
	public Task findById(Long id) {
		return taskMapper.findById(id);
	}

	@Override
	public void update(Task task) {
		taskMapper.update(task);
	}

	@Override
	public void delete(Long id) {
		taskMapper.delete(id);
	}
}