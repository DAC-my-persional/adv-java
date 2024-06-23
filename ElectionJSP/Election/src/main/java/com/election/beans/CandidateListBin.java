package com.election.beans;

import java.util.ArrayList;
import java.util.List;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

public class CandidateListBin {
	
	private List<Candidate> candidateList;
	public CandidateListBin()
	{
		this.candidateList = new ArrayList<Candidate>();
	}
	
	
	public List<Candidate> getCandidateList() {
		return candidateList;
	}


	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public void fetchCandidate()
	{
		try(CandidateDAO candidate = new CandidateDaoImpl())
		{
			candidateList = candidate.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
