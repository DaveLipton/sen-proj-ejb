package com.mfu.ejb;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employee_id;

	private String employee_first_name;
	private String employee_last_name;
	private String employee_email;
	private String employee_status;
	private String employee_username;
	private String employee_password;
	private String employee_code;
	private String employee_level;

	@ManyToOne(fetch = FetchType.EAGER)
	private Department employee_department_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Position employee_position_id;

	@OneToMany(mappedBy = "participate_employee_id", cascade = { CascadeType.ALL })
	private List<Participate> employee_participate_list;

	@OneToMany(mappedBy = "task_employee_id", cascade = { CascadeType.ALL })
	private List<Task> employee_task_list;
	
	@OneToMany(mappedBy = "task_emp_previous", cascade = { CascadeType.ALL })
	private List<Task> employee_task_list_previous;
	
	@JsonIgnore
	public List<Task> getEmployee_task_list_previous() {
		return employee_task_list_previous;
	}
	
	public void setEmployee_task_list_previous(List<Task> employee_task_list_previous) {
		this.employee_task_list_previous = employee_task_list_previous;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_first_name() {
		return employee_first_name;
	}

	public void setEmployee_first_name(String employee_first_name) {
		this.employee_first_name = employee_first_name;
	}

	public String getEmployee_last_name() {
		return employee_last_name;
	}

	public void setEmployee_last_name(String employee_last_name) {
		this.employee_last_name = employee_last_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	
	public Department getEmployee_department_id() {
		return employee_department_id;
	}

	public void setEmployee_department_id(Department employee_department_id) {
		this.employee_department_id = employee_department_id;
	}

	
	public Position getEmployee_position_id() {
		return employee_position_id;
	}

	public void setEmployee_position_id(Position employee_position_id) {
		this.employee_position_id = employee_position_id;
	}

	@JsonIgnore
	public List<Participate> getEmployee_participate_list() {
		return employee_participate_list;
	}

	public void setEmployee_participate_list(List<Participate> employee_participate_list) {
		this.employee_participate_list = employee_participate_list;
	}

	@JsonIgnore
	public List<Task> getEmployee_task_list() {
		return employee_task_list;
	}

	public void setEmployee_task_list(List<Task> employee_task_list) {
		this.employee_task_list = employee_task_list;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getEmployee_level() {
		return employee_level;
	}

	public void setEmployee_level(String employee_level) {
		this.employee_level = employee_level;
	}

}
