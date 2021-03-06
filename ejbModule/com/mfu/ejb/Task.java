package com.mfu.ejb;

import java.io.Serializable;
import java.util.Date;
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
public class Task implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long task_id;

	private String task_description;
	private Date task_estimate_start_date;
	private Date task_estimate_end_date;
	private String task_estimate_time;
	private String task_actual_time;

	private String task_file_path;
	private String task_type;
	private String task_status;
	private String task_priority;
	private String task_comment;

	@ManyToOne(fetch = FetchType.EAGER)
	private Job task_job_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee task_employee_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee task_emp_previous;

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getTask_file_path() {
		return task_file_path;
	}

	public void setTask_file_path(String task_file_path) {
		this.task_file_path = task_file_path;
	}

	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getTask_priority() {
		return task_priority;
	}

	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
	}

	public Employee getTask_employee_id() {
		return task_employee_id;
	}

	public void setTask_employee_id(Employee task_employee_id) {
		this.task_employee_id = task_employee_id;
	}

	public Job getTask_job_id() {
		return task_job_id;
	}

	public void setTask_job_id(Job task_job_id) {
		this.task_job_id = task_job_id;
	}

	public Date getTask_estimate_start_date() {
		return task_estimate_start_date;
	}

	public void setTask_estimate_start_date(Date task_estimate_start_date) {
		this.task_estimate_start_date = task_estimate_start_date;
	}

	public Date getTask_estimate_end_date() {
		return task_estimate_end_date;
	}

	public void setTask_estimate_end_date(Date task_estimate_end_date) {
		this.task_estimate_end_date = task_estimate_end_date;
	}

	public String getTask_comment() {
		return task_comment;
	}

	public void setTask_comment(String task_comment) {
		this.task_comment = task_comment;
	}

	public Employee getTask_emp_previous() {
		return task_emp_previous;
	}

	public void setTask_emp_previous(Employee task_emp_previous) {
		this.task_emp_previous = task_emp_previous;
	}

	public String getTask_estimate_time() {
		return task_estimate_time;
	}

	public void setTask_estimate_time(String task_estimate_time) {
		this.task_estimate_time = task_estimate_time;
	}

	public String getTask_actual_time() {
		return task_actual_time;
	}

	public void setTask_actual_time(String task_actual_time) {
		this.task_actual_time = task_actual_time;
	}

}
