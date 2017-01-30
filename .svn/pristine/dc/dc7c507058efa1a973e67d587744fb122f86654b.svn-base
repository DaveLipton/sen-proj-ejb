package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Role;

@Stateless
@Remote(RoleService.class)
public class RoleServiceImplement implements RoleService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		em.persist(role);
	}

	@Override
	public void edit(Role role) {
		// TODO Auto-generated method stub
		em.merge(role);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Role role = em.find(Role.class, id);
		em.remove(role);
	}

	@Override
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT role FROM Role role").getResultList();
	}

	@Override
	public Role findRoleById(long id) {
		return em.find(Role.class, id);
	}

	@Override
	public Role findRoleByRoleName(String role_name) {

		List<Role> listRole = em.createQuery("SELECT role FROM Role role WHERE role.role_name=:role_name")
				.setParameter("role_name", role_name).getResultList();

		Role role = listRole.get(0);
		return role;
	}

	@Override
	public Role findRoleByEmployeeAndProjectId(long emp_id, long proj_id) {
		Role role = new Role();
		List<Role> listRole = null;
		listRole = em
				.createQuery(
						"SELECT ro FROM Role ro, Participate prt WHERE ro.role_id=prt.participate_role_id.role_id AND prt.participate_employee_id.employee_id=:emp_id AND prt.participate_project_id.project_id=:proj_id")
				.setParameter("emp_id", emp_id).setParameter("proj_id", proj_id).getResultList();
		if (listRole != null) {
			role = listRole.get(0);
		}
		return role;
	}

}
