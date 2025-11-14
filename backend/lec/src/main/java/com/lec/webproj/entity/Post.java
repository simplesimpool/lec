package com.lec.webproj.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id")
    private Long postId;
    
    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String postContent;
    
    @Column(name = "post_reg_date", nullable = false)
    @Builder.Default
    private LocalDateTime postRegDate = LocalDateTime.now();
    
    @Column(name = "post_like_cnt", nullable = false)
    @Builder.Default
    private Long postLikeCnt = 0L;
    
    @Column(name = "post_is_del", nullable = false)
    @Builder.Default
    private Boolean postIsDel = false;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}