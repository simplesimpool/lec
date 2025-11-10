package com.lec.webproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.webproj.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
