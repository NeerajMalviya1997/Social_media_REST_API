package com.masai.Controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.CommentServiceImpl;
import com.masai.Service.PostServiceImpl;
import com.masai.Service.UserLogInServiceImpl;
import com.masai.Service.UserServiceImpl;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.model.User;
import com.masai.model.UserDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserLogInServiceImpl userLogInServiceImpl;
	
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	@PostMapping("/create")
	public  User  saveUser(@RequestBody User er) {
		User user= userServiceImpl.createUser(er);
		return user;
		
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user, @RequestParam(required = false) String key) {

		return userServiceImpl.updateUser(user, key);
	}
	
	@PostMapping("/login")
	public String logInUser(@RequestBody UserDto userDTO) throws Exception {
		return userLogInServiceImpl.logIntoAccount(userDTO);
	}
	
	@PatchMapping("/logout")
	public String logOutUser(@RequestParam(required = false) String key) {
		return userLogInServiceImpl.logOutAccount(key);
	}
	
	
	
	
	@PostMapping("/addpost/{mob}")
	public String savePost(@RequestBody Post post,@RequestParam String key,@PathVariable("mob") String mob) {
		return postServiceImpl.savePost(post, key, mob);
	}
	

	@DeleteMapping("/deletepost/{mob}")
	public String deletepost(@RequestParam Integer postid,@RequestParam String key,@PathVariable("mob") String mob) {
		return postServiceImpl.deletePost(postid, key, mob);
	}
	
	
	@GetMapping("/post")
	public Post getpostbyid(@RequestParam Integer postid) {
		return postServiceImpl.getpostbyid(postid);
	}
	
	@GetMapping("/allpost")
	public Post getallpostby(@RequestParam Integer postid) {
		return postServiceImpl.getpostbyid(postid);
	}
	
	@PostMapping("/comment")
	public String savecomment(@RequestBody Comment comment,@RequestParam String key,@RequestParam Integer postid) {
		return commentServiceImpl.addcomment(postid, key, comment);
	}
	
	@DeleteMapping("/comment")
	public String savePost(@RequestParam Integer commentid,@RequestParam Integer Userid) {
		return commentServiceImpl.deletecomment(commentid, Userid);
	}
	
}
