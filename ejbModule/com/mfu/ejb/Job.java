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
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Job implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long job_id;

	private String job_name;
	private String job_description;
	private Date job_estimate_start_date;
	private Date job_estimate_end_date;
	private long job_estimate_time;

	@ManyToOne(fetch = FetchType.EAGER)
	private Project job_project_id;

	@OneToMany(mappedBy = "task_job_id", cascade = { CascadeType.ALL })
	private List<Task> job_task_list;

	@OneToMany(mappedBy = "flow_job_id", cascade = { CascadeType.ALL })
	private List<Flowdirect> job_flow_id;

	public long getJob_id() {
		return job_id;
	}

	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	
	public Project getJob_project_id() {
		return job_project_id;
	}

	public void setJob_project_id(Project job_project_id) {
		this.job_project_id = job_project_id;
	}

	@JsonIgnore
	public List<Task> getJob_task_list() {
		return job_task_list;
	}

	public void setJob_task_list(List<Task> job_task_list) {
		this.job_task_list = job_task_list;
	}

	@JsonIgnore
	public List<Flowdirect> getJob_flow_id() {
		return job_flow_id;
	}

	public void setJob_flow_id(List<Flowdirect> job_flow_id) {
		this.job_flow_id = job_flow_id;
	}

	public Date getJob_estimate_start_date() {
		return job_estimate_start_date;
	}

	public void setJob_estimate_start_date(Date job_estimate_start_date) {
		this.job_estimate_start_date = job_estimate_start_date;
	}

	public Date getJob_estimate_end_date() {
		return job_estimate_end_date;
	}

	public void setJob_estimate_end_date(Date job_estimate_end_date) {
		this.job_estimate_end_date = job_estimate_end_date;
	}

	public long getJob_estimate_time() {
		return job_estimate_time;
	}

	public void setJob_estimate_time(long job_estimate_time) {
		this.job_estimate_time = job_estimate_time;
	}

}
