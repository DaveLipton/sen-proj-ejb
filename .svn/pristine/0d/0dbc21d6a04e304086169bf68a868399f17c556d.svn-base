package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Job;

@Stateless
@Remote(JobService.class)
public class JobServiceImplement implements JobService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Job job) {
		// TODO Auto-generated method stub
		em.persist(job);
	}

	@Override
	public void edit(Job job) {
		// TODO Auto-generated method stub
		em.merge(job);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Job job = em.find(Job.class, id);
		if (job!=null) {
			em.remove(job);
		}
	}

	@Override
	public Job findJobById(long id) {
		// TODO Auto-generated method stub
		return em.find(Job.class, id);
	}

	@Override
	public List<Job> listJobByProjectId(long id) {
		// TODO Auto-generated method stub
		List<Job> listJob = em.createQuery("SELECT job FROM Job job WHERE job.job_project_id.project_id =:proj_id")
				.setParameter("proj_id", id).getResultList();
		return listJob;
	}

	@Override
	public Job getlastJob() {
		List<Job> result = null;
		result = em.createQuery("SELECT job FROM Job job ORDER BY job.job_id DESC").getResultList();
		return result.get(0);
	}

}
