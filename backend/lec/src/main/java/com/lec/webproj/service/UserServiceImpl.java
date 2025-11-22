package com.lec.webproj.service;

import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.dto.LoginDTO;
import com.lec.webproj.entity.User;
import com.lec.webproj.entity.UserLoginState;
import com.lec.webproj.repository.UserLoginStateRepository;
import com.lec.webproj.repository.UserRepository;
import com.lec.webproj.utility.JwtUtility;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserLoginStateRepository userLoginStateRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final EntityManager entityManager;
	private final JwtUtility jwtUtility;
	
	private final Long EXP_TIME = 7L; //7 days
	private final int COOKIE_EXP_TIME = 60 * 60 * 24 * 7; //7 days
	@Override
	@Transactional
	public void join(JoinDTO dto) {
		Boolean isUserIdExists = userRepository.existsById(dto.getUserId());
		Boolean isUserNickNameExists = userRepository.existsByUserNickName(dto.getUserNickName());

		if (isUserIdExists) {
			throw new RuntimeException("중복된 아이디");
		} else if (isUserNickNameExists) {
			throw new RuntimeException("중복된 닉네임");
		} else {
			User user = User.builder()
					.userId(dto.getUserId())
					.userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
					.userFirstName(dto.getUserFirstName())
					.userLastName(dto.getUserLastName())
					.userNickName(dto.getUserNickName())
					.userEmail(dto.getUserEmail())
					.build();
			
			UserLoginState userLoginState = UserLoginState.builder()
					.user(user)
					.build();
			try {
				entityManager.persist(userLoginState);
				userRepository.save(user);
			} catch (Exception e) {
				throw new RuntimeException("회원가입 실패");
			}
		}
	}

	@Override
	@Transactional
	public Cookie login(LoginDTO dto) {
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("아이디가 존재 하지 않음"));
		Boolean isPwMatches = bCryptPasswordEncoder.matches(dto.getUserPw(), user.getUserPw());
		UserLoginState userLoginState = userLoginStateRepository.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("유저 상태 존재 안함"));
		
		if (isPwMatches) {
			LocalDateTime nowTime = LocalDateTime.now();
			userLoginState.setUserAvailLoginStartDate(nowTime);
			userLoginState.setUserLoginExpDate(nowTime.plusDays(EXP_TIME));
			
			Cookie cookie = new Cookie("accessToken", jwtUtility.generateToken(user.getUserUUID(), nowTime));
		    cookie.setHttpOnly(true);           
		    cookie.setSecure(true);             
		    cookie.setPath("/");
		    cookie.setMaxAge(COOKIE_EXP_TIME);
		    
		    return cookie;
		} else {
			throw new RuntimeException("비밀번호 일치 하지 않음");
		}
	}
}