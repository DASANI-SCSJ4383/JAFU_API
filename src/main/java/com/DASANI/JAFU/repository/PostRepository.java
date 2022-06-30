package com.DASANI.JAFU.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DASANI.JAFU.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query(value = "SELECT * FROM post WHERE groupID = :groupID", nativeQuery = true)
	public List<Post> findByGroupID(@Param("groupID") Long groupID);

	@Query(value = "SELECT * FROM post  WHERE groupID = :groupID && userID = :userID", nativeQuery = true)
	public List<Post> findByUserIDAndGroupID(@Param("groupID") Long groupID, @Param("userID") Long userID);
	
	
}
