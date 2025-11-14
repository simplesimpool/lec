package com.lec.webproj.entity;

import java.time.LocalDateTime;

import com.lec.webproj.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "user_id", length = 100)
    private String userId;

    @Column(name = "user_pw", nullable = false, length = 100)
    private String userPw;
    
    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;
    
    @Column(name = "user_nick_name", nullable = false, unique = true, length = 100)
    private String userNickName;

    @Column(name = "user_role", nullable = false, length = 50)
    @Builder.Default
    private String userRole = UserRole.USER.getRole();
    
    @Column(name = "user_reg_date", nullable = false)
    @Builder.Default
    private LocalDateTime userRegDate = LocalDateTime.now();
    
    @Column(name = "user_email", nullable = true, length = 100)
    private String userEmail;
    
    @Column(name = "user_is_del", nullable = false)
    @Builder.Default
    private Boolean userIsDel = false;
}