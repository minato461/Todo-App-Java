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
	public List<Task> findAll() {
		return taskMapper.findAll();
	}
	
	@Override
	public void insert(Task task) {
		taskMapper.insert(task);
	}
}