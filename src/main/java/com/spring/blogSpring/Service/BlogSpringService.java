package com.spring.blogSpring.Service;

import java.util.List;


import com.spring.blogSpring.Model.Post;

public interface BlogSpringService {

	List<Post> findAll();
	
	Post findById(long id);
	
	Post save (Post post);
}
