package com.mfu.service;

import java.util.List;

import com.mfu.ejb.Department;

public interface DepartmentService {

	public void add(Department dep);

	public void edit(Department dep);

	public void delete(long dep_id);
	
	public Department findDepartmentById(long id);

	public List<Department> listDepartment();

}
