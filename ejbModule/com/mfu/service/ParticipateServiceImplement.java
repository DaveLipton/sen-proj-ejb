package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Employee;
import com.mfu.ejb.Participate;
import com.mfu.ejb.Project;

@Stateless
@Remote(ParticipateService.class)
public class ParticipateServiceImplement implements ParticipateService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Participate prt) {
		em.persist(prt);
	}

	@Override
	public void edit(Participate prt) {
		em.merge(prt);
	}

	@Override
	public void delete(long id) {
		Participate prt = em.find(Participate.class, id);

		if (prt != null) {
			em.remove(prt);
		}
	}

	@Override
	public void deleteEmpFromTeam(Employee emp, Project proj) {
		List<Participate> listPrt = em
				.createQuery(
						"SELECT prt FROM Participate prt WHERE prt.participate_employee_id.employee_id=:emp_id AND prt.participate_project_id.project_id=:proj_id")
				.setParameter("emp_id", emp.getEmployee_id()).setParameter("proj_id", proj.getProject_id())
				.getResultList();
		Participate prt = listPrt.get(0);
		em.remove(prt);
	}

	@Override
	public Participate findPartById(long id) {
		// TODO Auto-generated method stub
		return em.find(Participate.class, id);
	}

	@Override
	public List<Participate> findRoleByEmployeeProject(Employee emp, Project proj) {
		List<Participate> listPrt = em
				.createQuery(
						"SELECT prt FROM Participate prt WHERE prt.participate_employee_id =:emp AND prt.participate_project_id=:proj")
				.setParameter("emp", emp).setParameter("proj", proj).getResultList();
		return listPrt;
	}

	@Override
	public List<Project> listProjectParticipateByEmployee(long empId) {
		// not project manager
		List<Project> listProj = em
				.createQuery(
						"SELECT proj FROM Project proj,Participate prt WHERE prt.participate_project_id =proj.project_id AND prt.participate_employee_id.employee_id =:empId")
				.setParameter("empId", empId).getResultList();
		return listProj;
	}

	@Override
	public List<Project> listProjectManagedByEmployee(Employee emp) {
		// employee is project manager
		List<Project> listProj = em
				.createQuery(
						"SELECT proj FROM Project proj,Participate prt WHERE prt.participate_project_id =proj.project_id AND prt.project_role ='Project Manager'AND prt.participate_employee_id=:emp")
				.setParameter("emp", emp).getResultList();
		return listProj;
	}

	@Override
	public List<Employee> listEmployeeByProject(Project proj) {
		List<Employee> listEmp = em
				.createQuery(
						"SELECT emp FROM Employee emp,Participate prt WHERE prt.participate_employee_id =emp.employee_id AND prt.participate_project_id=:proj")
				.setParameter("proj", proj).getResultList();
		return listEmp;
	}

	@Override
	public List<Employee> listEmployee() {
		List<Employee> listEmp = em.createQuery("SELECT emp FROM Employee emp").getResultList();
		return listEmp;
	}

	@Override
	public List<Participate> listParticipateByProject(Project proj) {
		List<Participate> listPrt = em
				.createQuery(
						"SELECT prt FROM Participate prt,Employee emp WHERE prt.participate_employee_id.employee_id =emp.employee_id AND prt.participate_project_id=:proj")
				.setParameter("proj", proj).getResultList();
		return listPrt;
	}

}
