package com.lec.webproj.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post_comment_like")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentLike {
	@EmbeddedId
	private PostCommentLikeId postCommentLikeId;
	   
	@Column(name = "post_cmt_like_reg_date", nullable = false)
	private Timestamp postCmtLikeRegDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("postCmtId")
	@JoinColumn(name = "post_cmt_id")
	private PostComment postComment;
}