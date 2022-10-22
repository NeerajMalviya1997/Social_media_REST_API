package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.PostRepo;
import com.masai.Repo.UserDao;
import com.masai.Repo.UserSessionDAO;
import com.masai.model.CurrentUserSession;
import com.masai.model.Post;
import com.masai.model.User;


@Service 
public class PostServiceImpl implements PostService {
	
	

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserSessionDAO usersessiondao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public String savePost(Post post, String key,String mob) {
		
         Optional<User> opt= userDao.findByMobileNo(mob);
		
		if(!opt.isPresent()) {
			throw new RuntimeException("user not present");
		}
     Optional<CurrentUserSession> currUserOpt=usersessiondao.findByUuid(key);
		
		if(!currUserOpt.isPresent()) {
			throw new RuntimeException("plz login first");
		}
		postRepo.save(post);
		
		opt.get().getPosts().add(post);
		userDao.save(opt.get());
		
     
		return "Post save succesfully";
	}

	@Override
	public String deletePost(Integer postid, String key,String mob) {

        Optional<User> opt= userDao.findByMobileNo(mob);
		
		if(!opt.isPresent()) {
			throw new RuntimeException("user not present");
		}
    Optional<CurrentUserSession> currUserOpt=usersessiondao.findByUuid(key);
		
		if(!currUserOpt.isPresent()) {
			throw new RuntimeException("plz login first");
		}
		postRepo.deleteById(postid);
		return "Post deleted";
	}

	@Override
	public Post getpostbyid(Integer postid) {
		// TODO Auto-generated method stub
		
	
		return postRepo.getById(postid);
	}

	@Override
	public List<Post> getallPost(Integer Userid) {
	User user=	userDao.getById(Userid);
	
	return user.getPosts();
		
	}

	
	
	

}
