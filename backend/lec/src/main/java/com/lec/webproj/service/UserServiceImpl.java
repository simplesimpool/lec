package com.lec.webproj.service;

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
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final EntityManager entityManager;
	private final JwtUtility jwtUtility;
	
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
			User newUser = User.builder()
					.userId(dto.getUserId())
					.userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
					.userFirstName(dto.getUserFirstName())
					.userLastName(dto.getUserLastName())
					.userNickName(dto.getUserNickName())
					.userEmail(dto.getUserEmail())
					.build();
			
			UserLoginState newUserLoginState = UserLoginState.builder()
					.user(newUser)
					.build();
			try {
				entityManager.persist(newUserLoginState);
				userRepository.save(newUser);
			} catch (Exception e) {
				throw new RuntimeException("회원가입 실패");
			}
		}
	}

	@Override
	@Transactional
	public void login(LoginDTO dto) {
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("아이디가 존재 하지 않음"));
		Boolean isPwMatches = bCryptPasswordEncoder.matches(dto.getUserPw(), user.getUserPw());
		
		if (isPwMatches) {
			System.out.println("asdf");
		} else {
			throw new RuntimeException("비밀번호 일치 하지 않음");
		}
	}
}