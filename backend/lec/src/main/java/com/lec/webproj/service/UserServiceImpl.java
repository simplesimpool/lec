package com.lec.webproj.service;

import javax.management.RuntimeErrorException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.entity.User;
import com.lec.webproj.entity.UserLoginState;
import com.lec.webproj.repository.UserLoginStateRepository;
import com.lec.webproj.repository.UserRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final EntityManager entityManager;
	
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
			User savedUser = null;
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

			entityManager.persist(newUserLoginState);
			newUser.setUserLoginState(newUserLoginState);
			savedUser = userRepository.save(newUser);
			
			if (savedUser == null) throw new RuntimeException("회원가입 실패");
		}
	}
}