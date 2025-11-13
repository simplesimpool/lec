package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.PostCommentLike;
import com.lec.webproj.entity.PostCommentLikeId;

public interface PostCommentLikeRepository extends JpaRepository<PostCommentLike, PostCommentLikeId> {

}
