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
public class Position implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long position_id;

	private String position_name;
	private String position_description;
	private String position_status;

	@OneToMany(mappedBy = "employee_position_id", cascade = { CascadeType.ALL })
	private List<Employee> position_employee_list;

	public long getPosition_id() {
		return position_id;
	}

	public void setPosition_id(long position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getPosition_description() {
		return position_description;
	}

	public void setPosition_description(String position_description) {
		this.position_description = position_description;
	}

	public String getPosition_status() {
		return position_status;
	}

	public void setPosition_status(String position_status) {
		this.position_status = position_status;
	}

	@JsonIgnore
	public List<Employee> getPosition_employee_list() {
		return position_employee_list;
	}

	public void setPosition_employee_list(List<Employee> position_employee_list) {
		this.position_employee_list = position_employee_list;
	}
}
