package com.DASANI.JAFU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DASANI.JAFU.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM user WHERE phoneNum = :phoneNum", nativeQuery = true)
	public User findByPhoneNum(@Param("phoneNum") String phoneNum);
}
