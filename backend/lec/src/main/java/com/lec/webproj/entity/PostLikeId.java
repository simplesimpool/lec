package com.lec.webproj.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PostLikeId implements Serializable {
	private String userId;
	private Long postId;
}
