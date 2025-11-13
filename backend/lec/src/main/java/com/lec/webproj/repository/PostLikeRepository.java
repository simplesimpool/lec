package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.PostLike;
import com.lec.webproj.entity.PostLikeId;

public interface PostLikeRepository extends JpaRepository<PostLike, PostLikeId>{

}
