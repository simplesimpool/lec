package com.lec.webproj.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PostCommentLikeId implements Serializable {
	private String userId;
	private Long postCmtId;
}
