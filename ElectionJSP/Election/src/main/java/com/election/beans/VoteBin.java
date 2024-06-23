package com.election.beans;

import java.util.List;

import com.election.DAO.CandidateDAO;
import com.election.DAO.CandidateDaoImpl;
import com.election.DAO.UserDAO;
import com.election.DAO.UserDaoImpl;
import com.election.entity.Candidate;
import com.election.entity.User;

public class VoteBin {
	private int id;
	private User user;
	private int count;
	private boolean valid = false;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public boolean isValid() {
		return valid;
	}


	public void setValid(boolean valid) {
		this.valid = valid;
	}


	public void voteIncrement()
	{
		try
		{
			
			if(user.getStatus()!= 1)
			{
				CandidateDAO candidateDaO = new CandidateDaoImpl();
				count = candidateDaO.incrementVote(id);
				
				UserDAO userdao = new UserDaoImpl();
				userdao.updateStatus(user.getId(),true);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
