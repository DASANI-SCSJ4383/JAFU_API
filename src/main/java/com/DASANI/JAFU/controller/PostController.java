package com.DASANI.JAFU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DASANI.JAFU.model.Post;
import com.DASANI.JAFU.model.User;
import com.DASANI.JAFU.service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    
    @RequestMapping(value="/getPost/{groupID}", method=RequestMethod.GET)
    public List<Post> getPosts(@PathVariable(value = "groupID") Long groupID) {
    	List<Post> posts = postService.getPostsByGroup(groupID);
    	postService.combineUserWithPost(posts);
		return posts;
    }
    
    @RequestMapping(value="/getMyPost/{groupID}/{userID}", method=RequestMethod.GET)
    public List<Post> getPost(@PathVariable(value = "groupID") Long groupID, @PathVariable(value = "userID") Long userID) {
    	List<Post> posts = postService.getUserPostsByGroup(groupID, userID);
    	postService.combineUserWithPost(posts);
		return posts;
    }
    
    @RequestMapping(value="/editPost/{id}", method=RequestMethod.PUT)
    public String editPost(@PathVariable(value = "id") Long id, @RequestBody Post post) {
    	postService.updatePost(id, post);
    	return "success";
    }
}
