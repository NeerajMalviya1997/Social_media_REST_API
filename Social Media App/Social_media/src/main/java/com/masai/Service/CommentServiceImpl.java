package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.CommentRepo;
import com.masai.Repo.PostRepo;
import com.masai.Repo.UserDao;
import com.masai.Repo.UserSessionDAO;
import com.masai.model.Comment;
import com.masai.model.CurrentUserSession;
import com.masai.model.Post;

@Service
public class CommentServiceImpl implements CommentService {
	

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserSessionDAO usersessiondao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public String addcomment(Integer postid, String key,Comment comment) {
		 Optional<CurrentUserSession> currUserOpt=usersessiondao.findByUuid(key);
			
			if(!currUserOpt.isPresent()) {
				throw new RuntimeException("plz login first");
			}
			
		Post post=postRepo.getById(postid);
		post.getComment().add(comment);
		postRepo.save(post);
		return "comment save";
	}

	@Override
	public String deletecomment(Integer commentId, Integer UserId) {
		commentRepo.deleteById(UserId);
		return "deleted";
	}

}
