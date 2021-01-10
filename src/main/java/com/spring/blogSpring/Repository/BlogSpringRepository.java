package com.spring.blogSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blogSpring.Model.Post;

public interface BlogSpringRepository extends JpaRepository<Post, Long> {

}
