package com.mfu.service;

import java.util.List;

import com.mfu.ejb.Employee;
import com.mfu.ejb.Participate;
import com.mfu.ejb.Project;

public interface ParticipateService {
	public void add(Participate prt);

	public void edit(Participate prt);

	public void delete(long id);

	public void deleteEmpFromTeam(Employee emp, Project proj);

	public Participate findPartById(long id);

	public List<Participate> findRoleByEmployeeProject(Employee emp, Project proj);

	public List<Project> listProjectManagedByEmployee(Employee emp);

	public List<Project> listProjectParticipateByEmployee(long empId);

	public List<Employee> listEmployeeByProject(Project proj);

	public List<Participate> listParticipateByProject(Project proj);

	public List<Employee> listEmployee();

}
