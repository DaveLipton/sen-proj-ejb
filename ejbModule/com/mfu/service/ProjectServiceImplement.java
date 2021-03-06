package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Project;

@Stateless
@Remote(ProjectService.class)
public class ProjectServiceImplement implements ProjectService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Project proj) {
		// TODO Auto-generated method stub
		em.persist(proj);
	}

	@Override
	public void edit(Project proj) {
		// TODO Auto-generated method stub
		em.merge(proj);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Project proj = em.find(Project.class, id);
		// also check if started

		if (proj != null) {
			em.remove(proj);
		}
	}

	@Override
	public Project findProjectById(long id) {
		// TODO Auto-generated method stub
		return em.find(Project.class, id);
	}

	@Override
	public List<Project> listProject() {
		List<Project> listProj = em.createQuery("SELECT proj FROM Project proj ORDER BY proj.project_created_time").getResultList();
		return listProj;
	}

	@Override
	public List<Project> listProjectByEmployee(long emp_id) {
		List<Project> listProj = em
				.createQuery(
						"SELECT proj FROM Project proj JOIN proj.Participate part WHERE part.participate_employee_id=:employee_id")
				.setParameter("employee_id", emp_id).getResultList();
		return listProj;
	}
}
