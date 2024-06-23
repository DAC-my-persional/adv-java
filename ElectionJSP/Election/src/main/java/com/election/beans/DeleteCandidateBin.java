package com.election.beans;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

public class DeleteCandidateBin {
	private int id;
	private int count;
	
	
	
	public DeleteCandidateBin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void deleteCandidate()
	{
		try(CandidateDAO candidateDao = new CandidateDaoImpl())
		{
			count = candidateDao.deleteById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
