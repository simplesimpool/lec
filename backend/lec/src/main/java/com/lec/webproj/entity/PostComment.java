package com.lec.webproj.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_cmt_id")
    private Long postCmtId;
    
    @Column(name = "post_cmt_content", nullable = false, columnDefinition = "TEXT")
    private String postCmtConent;
    
    @Column(name = "post_cmt_reg_date", nullable = false)
    private Timestamp postCmtRegDate;
    
    @Column(name = "post_cmt_like_cnt", nullable = false)
    @Builder.Default
    private Long postCmtLikeCnt = 0L;
    
    @Column(name = "post_cmt_is_del", nullable = false)
    @Builder.Default
    private Boolean postCmtIsDel = false;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_cmt_p_id", nullable = true)
    private PostComment postComment;
}