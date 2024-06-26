package com.sunbeam.service;

import com.sunbeam.entities.Comment;

public interface CommentService {
//delete all comments by blog post id
	String deleteComments(Long blogPostId);

	String addComment(Long commenterId, Long blogPostId, Comment comment);
}
