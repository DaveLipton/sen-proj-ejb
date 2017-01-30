package com.mfu.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Flowdirect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flow_id;

	private long flow_emp_prev;
	private long flow_emp_next;

	@ManyToOne(fetch = FetchType.EAGER)
	private Job flow_job_id;

	public long getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(long flow_id) {
		this.flow_id = flow_id;
	}

	
	public Job getFlow_job_id() {
		return flow_job_id;
	}

	public void setFlow_job_id(Job flow_job_id) {
		this.flow_job_id = flow_job_id;
	}

	public long getFlow_emp_prev() {
		return flow_emp_prev;
	}

	public void setFlow_emp_prev(long flow_emp_prev) {
		this.flow_emp_prev = flow_emp_prev;
	}

	public long getFlow_emp_next() {
		return flow_emp_next;
	}

	public void setFlow_emp_next(long flow_emp_next) {
		this.flow_emp_next = flow_emp_next;
	}

}
