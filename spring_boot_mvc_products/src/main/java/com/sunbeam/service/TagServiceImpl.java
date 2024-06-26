package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService {
	@Autowired
	private TagDao tagDao;

	@Autowired
	private BlogPostDao blogPostDao;

	@Override
	public String assignPostAndTag(Long tagId, Long postId) {
		// get tag
		Tag tag = tagDao.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Invalid Tag ID!!"));
		// get post
		BlogPost post = blogPostDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Post ID!!"));

		// establish uni dir association Tag *--->* Post
		tag.getPosts().add(post);

		return "added tag to post";

	}
	public String removePostFromTag(Long tagId, Long postId) {
		// get tag
		Tag tag = tagDao.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Invalid Tag ID!!"));
		// get post
		BlogPost post = blogPostDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Post ID!!"));

		//un establish uni dir association Tag *--->* Post
		tag.getPosts().remove(post);
		return "added tag to post";

	}

}
