package com.DASANI.JAFU.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DASANI.JAFU.model.Post;
import com.DASANI.JAFU.service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    
    @RequestMapping(value="/getPost/{groupID}", method=RequestMethod.GET)
    public List<Post> getPosts(@PathVariable(value = "groupID") Long groupID) {
		return postService.getPostsByGroup(groupID);
    }
    
    @RequestMapping(value="/getMyPost/{groupID}/{userID}", method=RequestMethod.GET)
    public List<Post> getPost(@PathVariable(value = "groupID") Long groupID, @PathVariable(value = "userID") Long userID) {
		return postService.getUserPostsByGroup(groupID, userID);
    }

}
