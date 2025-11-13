package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
