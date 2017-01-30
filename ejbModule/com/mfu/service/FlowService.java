package com.mfu.service;

import java.util.List;

import com.mfu.ejb.Flowdirect;
import com.mfu.ejb.Job;
import com.mfu.ejb.Project;
import com.mfu.ejb.Task;

public interface FlowService {

	public void add(Flowdirect flow);

	public void edit(Flowdirect flow);

	public Flowdirect findFlowById(long id);

	public List<Flowdirect> findFlowByJobId(long id);
	
	public List<Flowdirect> findPrevoiusEmployeeById(long empId,long jobId);
	
	public List<Flowdirect> findNextEmployeeById(long empId,long jobId);

	public void delete(long id);

}
