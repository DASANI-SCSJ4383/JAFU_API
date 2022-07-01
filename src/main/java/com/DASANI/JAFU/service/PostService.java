package com.DASANI.JAFU.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DASANI.JAFU.model.Post;
import com.DASANI.JAFU.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    // READ
    public List<Post> getPostsByGroup(Long groupID) {
        return postRepository.findByGroupID(groupID);
    }
    
    public List<Post> getUserPostsByGroup(Long groupID, Long userID){
    	return postRepository.findByUserIDAndGroupID(groupID, userID);
    }
    
    public void combineUserWithPost(List<Post> posts) {
    	for(Post post : posts) {
    		post.setUsername(post.getUser().getUsername());
    		post.setPhoneNum(post.getUser().getPhoneNum());
    	}
    }
    
    // UPDATE
    public Post updatePost(Long id, Post postDetail) {
		Post post = postRepository.findById(id).get();
		
		post.setTitle(postDetail.getTitle());
		post.setPrice(postDetail.getPrice());
		post.setDescription(postDetail.getDescription());
        
        return postRepository.save(post);                                
    }
}
