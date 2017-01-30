package com.mfu.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Task;

@Stateless
@Remote(TaskService.class)
public class TaskServiceImplement implements TaskService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Task tsk) {
		// TODO Auto-generated method stub
		em.persist(tsk);
	}

	@Override
	public void edit(Task tsk) {
		// TODO Auto-generated method stub
		em.merge(tsk);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Task tsk = em.find(Task.class, id);

		em.remove(tsk);
	}

	@Override
	public Task findTaskById(long id) {
		// TODO Auto-generated method stub
		return em.find(Task.class, id);
	}

	@Override
	public List<Task> listTaskByEmployee(long employee_id) {
		// TODO Auto-generated method stub
		List<Task> listTask = em
				.createQuery("SELECT tsk FROM Task tsk WHERE tsk.task_employee_id.employee_id=:employee_id")
				.setParameter("employee_id", employee_id).getResultList();
		return listTask;
	}

	@Override
	public List<Task> listTaskByJob(long job_id) {
		List<Task> listTask = em.createQuery("SELECT tsk FROM Task tsk WHERE tsk.task_job_id.job_id=:job_id")
				.setParameter("job_id", job_id).getResultList();
		return listTask;
	}

	@Override
	public List<Task> listTaskByProject(long proj_id) {
		return em.createQuery("SELECT tsk FROM Task tsk WHERE tsk.task_job_id.job_project_id.project_id =:projId")
				.setParameter("projId", proj_id).getResultList();
	}

	@Override
	public List<Task> listTaskByProjectAndEmployee(long proj_id, long empId) {

		return em
				.createQuery(
						"SELECT tsk FROM Task tsk WHERE tsk.task_job_id.job_project_id.project_id =:projId AND tsk.task_employee_id.employee_id =:empId")
				.setParameter("projId", proj_id).setParameter("empId", empId).getResultList();
	}

}
