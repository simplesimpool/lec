package com.lec.webproj.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_login_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginState {
    @Id
    @Column(name = "user_id", length = 100)
    private String userId;
    
    @Column(name = "user_avail_login_start_date", nullable = true)
    @Builder.Default
    private LocalDateTime userAvailLoginStartDate = null;
    
    @Column(name = "user_login_exp_date", nullable = true)
    @Builder.Default
    private LocalDateTime userLoginExpDate = null;
    
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
}