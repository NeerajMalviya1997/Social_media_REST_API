package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Post;

public interface PostRepo extends JpaRepository<Post,Integer> {

}
