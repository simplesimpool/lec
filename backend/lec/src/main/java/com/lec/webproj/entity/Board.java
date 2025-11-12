package com.lec.webproj.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_name", nullable = false, length = 100)
    private String boardName;
    
    @Column(name = "board_reg_date", nullable = false)
    private Timestamp boardRegDate;
    
    @Column(name = "board_is_del", nullable = false)
    @Builder.Default
    private Boolean boardIsDel = false;
}