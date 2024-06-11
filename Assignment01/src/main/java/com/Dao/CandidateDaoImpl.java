package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Candidate;
import com.utils.DbUtil;

public class CandidateDaoImpl implements AutoCloseable {
	private Connection connection;
	
	public CandidateDaoImpl() throws Exception {
		connection = DbUtil.getConnection();
	}
	
	

	public List<Candidate> findAll() throws Exception{
		String queryText = "select * from candidates";
		List<Candidate> candidateList = null;
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			ResultSet rs = smt.executeQuery();
			candidateList = new ArrayList<Candidate>();
			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt(1));
				candidate.setName(rs.getNString(2));
				candidate.setParty(rs.getString(3));
				candidate.setId(rs.getInt(4));
				candidateList.add(candidate);
			}
		}
		return candidateList;
	}
	public List<Candidate> findByParty(String party) throws Exception{
		String queryText = "select * from candidates where party=?";
		List<Candidate> candidateList = findAll();
		Candidate candidate = new Candidate();
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			smt.setString(1, party);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				candidate.setId(rs.getInt(1));
				candidate.setName(rs.getNString(2));
				candidate.setParty(rs.getString(3));
				candidate.setId(rs.getInt(4));
				candidateList.add(candidate);

//				System.out.println(candidate.toString());
			}
		}
		return candidateList;
	}
	public List<Candidate> findAllOrderByVotesDesc() throws Exception{
		String queryText = "select * from candidates order by 3 desc";
		List<Candidate> candidateList = findAll();
		Candidate candidate = new Candidate();
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				candidate.setId(rs.getInt(1));
				candidate.setName(rs.getNString(2));
				candidate.setParty(rs.getString(3));
				candidate.setId(rs.getInt(4));
				candidateList.add(candidate);

//				System.out.println(candidate.toString());
			}
		}
		return candidateList;
	}
	public int save(Candidate c) throws Exception{
		String sql = "insert into candidates values(default,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getParty());
			stmt.setInt(3, c.getVotes());
			stmt.executeUpdate();
		}
		return 0;
	}
	public int deleteById(int id) throws Exception{
		String sql = "delete from candidatets where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		return 0;
	}
	public int update(Candidate c) throws Exception{
		String sql = "update users set first_name=?,last_name=?,email=?,password=?,dob=?,status=?,role=? where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getParty());
			stmt.setInt(3, c.getVotes());
			stmt.executeUpdate();
		}
		return 0;
	}
	public Candidate findById(int id) throws Exception{
		String queryText = "select * from candidates where id=?";
		List<Candidate> candidateList = findAll();
		Candidate candidate = new Candidate();
		try (PreparedStatement smt = connection.prepareStatement(queryText)) {
			smt.setInt(1, id);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				candidate.setId(rs.getInt(1));
				candidate.setName(rs.getNString(2));
				candidate.setParty(rs.getString(3));
				candidate.setId(rs.getInt(4));
				candidateList.add(candidate);

//				System.out.println(candidate.toString());
			}
		}
		return candidate;
	}
	

	@Override
	public void close() throws Exception {
		if (connection != null)
			connection.close();
	}
}
