package com.lec.webproj.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.webproj.dto.JoinDTO;
import com.lec.webproj.entity.User;
import com.lec.webproj.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
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
			User user = User.builder()
					.userId(dto.getUserId())
					.userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
					.userName(dto.getUserName())
					.userNickName(dto.getUserNickName())
					.userEmail(dto.getUserEmail())
					.build();
			return 0;
		}
	}
}