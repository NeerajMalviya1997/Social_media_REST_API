package com.masai.Service;

import com.masai.model.Comment;

public interface CommentService {

	public String addcomment(Integer postid,String key,Comment comment);
	public String deletecomment(Integer commentId,Integer UserId);
}
