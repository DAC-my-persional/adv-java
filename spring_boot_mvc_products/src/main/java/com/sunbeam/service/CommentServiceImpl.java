package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogPostDao blogPostDao;

	@Override
	public String deleteComments(Long blogPostId) {
		int rows=commentDao.deleteByPostId(blogPostId);
		return "deleted comments -"+rows;
	}
	@Override
	public String addComment(Long commenterId,Long blogPostId,
			Comment comment) {
		// get commenter
		User commenter = userDao.findById(commenterId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid commenter id!!!"));
		// get post
		BlogPost post = blogPostDao.findById(blogPostId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid post id!!!"));
		// validate - blogger can't add the comment on his/her own post
		if (commenter.getId() == post.getBlogger().getId())
			throw new ApiException("Bloggers can't comment on their own posts !!!!!");
			// establish the associations
		// comment--> user
		comment.setCommenter(commenter);
		// comment --> post
		comment.setPost(post);
		// since there is no cascading , you will have to explicitly save
		Comment savedComment = commentDao.save(comment);
		return "new comment added with id=" + savedComment.getId();
	}


}
