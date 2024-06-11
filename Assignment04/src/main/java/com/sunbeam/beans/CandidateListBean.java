package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {

	public List<Candidate> candidateList() {
		List<Candidate> list=new ArrayList<Candidate>();
		
		try(CandidateDao cdao=new CandidateDaoImpl()){
			list=cdao.findAll();
				return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
