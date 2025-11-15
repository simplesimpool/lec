package com.lec.webproj.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.entity.User;
import com.lec.webproj.entity.UserLoginState;
import com.lec.webproj.repository.UserLoginStateRepository;
import com.lec.webproj.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserLoginStateRepository userLoginStateRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public int join(JoinDTO dto) {
		Boolean isUserIdExists = userRepository.existsById(dto.getUserId());
		Boolean isUserNickNameExists = userRepository.existsByUserNickName(dto.getUserNickName());

		if (isUserIdExists) {
			return 1;
		} else if (isUserNickNameExists) {
			return 2;
		} else {
			User savedUser = null;
			User newUser = User.builder()
					.userId(dto.getUserId())
					.userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
					.userName(dto.getUserName())
					.userNickName(dto.getUserNickName())
					.userEmail(dto.getUserEmail())
					.build();
			savedUser = userRepository.save(newUser);
			if (savedUser == null) return 3;
			
			UserLoginState SavedUserLoginState = null;
			UserLoginState newUserLoginState = UserLoginState.builder()
					.userId(savedUser.getUserId())
					.userAvailLoginStartDate(null)
					.userExpLoginDate(null)
					.build();
			
			return 0;
		}
	}
}