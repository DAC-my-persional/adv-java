package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Tag;

public interface TagDao extends JpaRepository<Tag,Long> {
//get all tags by given post id
	@Query("select t from Tag t join t.posts p where p.id=:blogPostId")
	List<Tag> findTagsByPostId(Long blogPostId);
	

}
