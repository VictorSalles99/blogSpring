package com.spring.blogSpring.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogSpring.Model.Post;
import com.spring.blogSpring.Repository.BlogSpringRepository;
import com.spring.blogSpring.Service.BlogSpringService;

@Service
public class BlogSpringServiceImpl implements BlogSpringService{

	@Autowired 
	BlogSpringRepository blogSpringRepository;
	
	@Override
	public List<Post> findAll() {
		return blogSpringRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return blogSpringRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return blogSpringRepository.save(post);
	}

}
