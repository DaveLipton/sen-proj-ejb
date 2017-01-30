package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Department;

@Stateless
@Remote(DepartmentService.class)
public class DepartmentServiceImplement implements DepartmentService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Department dep) {
		// TODO Auto-generated method stub
		em.persist(dep);
	}

	@Override
	public void edit(Department dep) {
		// TODO Auto-generated method stub
		em.merge(dep);
	}

	@Override
	public void delete(long dep_id) {
		Department dep = em.find(Department.class, dep_id);
		if (dep != null) {
			dep.setDepartment_status("Inactive");
		}
	}

	@Override
	public Department findDepartmentById(long id) {
		return em.find(Department.class, id);
	}

	@Override
	public List<Department> listDepartment() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT dep FROM Department dep").getResultList();
	}

}
