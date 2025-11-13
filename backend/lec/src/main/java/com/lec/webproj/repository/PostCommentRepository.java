package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>{
	
}
