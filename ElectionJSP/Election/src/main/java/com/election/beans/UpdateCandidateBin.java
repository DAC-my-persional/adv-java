package com.election.beans;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.entity.Candidate;

public class UpdateCandidateBin {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	public UpdateCandidateBin() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void updateCandidate()
	{
		Candidate cand = new Candidate(id,name,party,votes);
		try(CandidateDAO candidateDao = new CandidateDaoImpl())
		{
			 count = candidateDao.update(cand);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
