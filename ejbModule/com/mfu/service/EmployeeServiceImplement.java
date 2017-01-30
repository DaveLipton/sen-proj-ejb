package com.mfu.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Employee;

@Stateless
@Remote(EmployeeService.class)
public class EmployeeServiceImplement implements EmployeeService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Employee emp) {
		String md5pw = hashPassword(emp.getEmployee_password());
		emp.setEmployee_password(md5pw);
		em.persist(emp);
	}

	@Override
	public void edit(Employee edti_emp) {
		em.merge(edti_emp);
	}

	@Override
	public void delete(long emp_id) {
		// TODO Auto-generated method stub
		Employee emp = em.find(Employee.class, emp_id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	@Override
	public void disable(long id) {
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			emp.setEmployee_status("Inactive");
			em.persist(emp);
		} else {
		}
	}

	@Override
	public String hashPassword(String pw) {
		String md5 = null;
		if (pw == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pw.getBytes(), 0, pw.length());
			md5 = new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return md5;
	}

	@Override
	public Employee findEmployeeById(long emp_id) {
		// TODO Auto-generated method stub
		return em.find(Employee.class, emp_id);
	}

	@Override
	public Employee findEmployeeByUsername(String uname) {
		Employee emp = new Employee();
		List<Employee> empList = em.createQuery("SELECT emp FROM Employee emp WHERE emp.employee_username=:emp_uname")
				.setParameter("emp_uname", uname).getResultList();

		if (empList.get(0) != null) {
			emp = empList.get(0);
			return emp;
		} else {
			return null;
		}

	}

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList = em.createQuery("SELECT emp FROM Employee emp").getResultList();
		return empList;
	}

	@Override
	public List<Employee> listEmployeeByDepartment(long dep_id) {
		List<Employee> empList = em
				.createQuery(
						"SELECT emp FROM Employee emp WHERE emp.employee_department_id.department_id=:department_id")
				.setParameter("department_id", dep_id).getResultList();
		return empList;
	}

	@Override
	public List<Employee> listEmployeeByPosition(long pos_id) {
		List<Employee> empList = em
				.createQuery("SELECT emp FROM Employee emp WHERE emp.employee_position_id.position_id=:position_id")
				.setParameter("position_id", pos_id).getResultList();
		return empList;
	}

}
