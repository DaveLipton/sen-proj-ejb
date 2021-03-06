package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.mfu.ejb.Task;

public interface TaskService {

	public void add(Task tsk);

	public void edit(Task tsk);

	public void delete(long id);

	public Task findTaskById(long id);

	public List<Task> listTaskByEmployee(long id);

	public List<Task> listTaskByJob(long job_id);

	public List<Task> listTaskByProject(long proj_id);
	
	public List<Task> listTaskByProjectAndEmployee(long proj_id ,long empId);

}
