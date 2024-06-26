package com.sunbeam.service;

public interface TagService {
	String assignPostAndTag(Long tagId, Long postId);
	String removePostFromTag(Long tagId, Long postId);
}
