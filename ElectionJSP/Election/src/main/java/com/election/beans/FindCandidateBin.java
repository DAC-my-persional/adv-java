package com.election.beans;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

public class FindCandidateBin {
	private int id;
	private Candidate candidate;
	
	
	public FindCandidateBin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void fetchCandidate()
	{
		try(CandidateDAO candidateDao = new CandidateDaoImpl())
		{
			candidate = candidateDao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
