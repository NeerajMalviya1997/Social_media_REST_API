package com.masai.Service;

import java.util.List;

import com.masai.model.Post;

public interface PostService {

	public String savePost(Post post,String key,String mob);
	public String deletePost(Integer postid,String key,String mob);
	public Post getpostbyid(Integer postid);
	public List<Post> getallPost(Integer Userid);
	
}
