package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Flowdirect;
import com.mfu.ejb.Job;
import com.mfu.ejb.Project;
import com.mfu.ejb.Task;

@Stateless
@Remote(FlowService.class)
public class FlowServiceImplement implements FlowService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Flowdirect flow) {
		// TODO Auto-generated method stub
		em.persist(flow);
	}

	@Override
	public void edit(Flowdirect flow) {
		// TODO Auto-generated method stub
		em.merge(flow);
	}

	@Override
	public void delete(long id) {
		Flowdirect flow = em.find(Flowdirect.class, id);
		if (flow != null) {
			em.remove(flow);
		}
	}

	public Flowdirect findFlowById(long id) {
		return em.find(Flowdirect.class, id);
	}

	public List<Flowdirect> findFlowByJobId(long id) {
		List<Flowdirect> flowDiList = em.createQuery("SELECT f FROM Flowdirect f WHERE f.flow_job_id.job_id =:param")
				.setParameter("param", id).getResultList();
		return flowDiList;
	}

	@Override
	public List<Flowdirect> findPrevoiusEmployeeById(long empId, long jobId) {

		List<Flowdirect> result = em
				.createQuery(
						"SELECT f FROM Flowdirect f WHERE f.flow_job_id.job_id=:param AND f.flow_emp_next=:param2 ")
				.setParameter("param", jobId).setParameter("param2", empId).getResultList();
		return result;
	}

	@Override
	public List<Flowdirect> findNextEmployeeById(long empId, long jobId) {
		List<Flowdirect> result = em
				.createQuery(
						"SELECT f FROM Flowdirect f WHERE f.flow_job_id.job_id=:param AND f.flow_emp_prev=:param2 ")
				.setParameter("param", jobId).setParameter("param2", empId).getResultList();
		return result;
	}

}
