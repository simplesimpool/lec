package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
}
