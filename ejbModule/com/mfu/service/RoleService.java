package com.mfu.service;

import java.util.List;

import com.mfu.ejb.Role;

public interface RoleService {

	public void add(Role role);

	public void edit(Role role);

	public void delete(long id);

	public Role findRoleById(long id);

	public Role findRoleByRoleName(String role_name);

	public List<Role> listRole();

	public Role findRoleByEmployeeAndProjectId(long emp_id, long proj_id);

}
