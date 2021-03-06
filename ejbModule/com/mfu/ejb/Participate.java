package com.mfu.ejb;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Participate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long participate_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Employee participate_employee_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Project participate_project_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role participate_role_id;

	public Employee getParticipate_employee_id() {
		return participate_employee_id;
	}

	public void setParticipate_employee_id(Employee participate_employee_id) {
		this.participate_employee_id = participate_employee_id;
	}

	public Project getParticipate_project_id() {
		return participate_project_id;
	}

	public void setParticipate_project_id(Project participate_project_id) {
		this.participate_project_id = participate_project_id;
	}

	/**
	 * @return the participate_id
	 */
	public long getParticipate_id() {
		return participate_id;
	}

	/**
	 * @param participate_id
	 *            the participate_id to set
	 */
	public void setParticipate_id(long participate_id) {
		this.participate_id = participate_id;
	}

	public Role getParticipate_role_id() {
		return participate_role_id;
	}

	public void setParticipate_role_id(Role participate_role_id) {
		this.participate_role_id = participate_role_id;
	}

}
