package com.mfu.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long department_id;

	private String department_name;
	private String department_description;
	private String department_status;

	@OneToMany(mappedBy = "employee_department_id", cascade = { CascadeType.ALL })
	private List<Employee> department_employee_list;

	public long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_description() {
		return department_description;
	}

	public void setDepartment_description(String department_description) {
		this.department_description = department_description;
	}

	public String getDepartment_status() {
		return department_status;
	}

	public void setDepartment_status(String department_status) {
		this.department_status = department_status;
	}

	@JsonIgnore
	public List<Employee> getDepartment_employee_list() {
		return department_employee_list;
	}

	public void setDepartment_employee_list(List<Employee> department_employee_list) {
		this.department_employee_list = department_employee_list;
	}
}
