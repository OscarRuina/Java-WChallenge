package com.java.WChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WChallenge.models.CommentModel;
import com.java.WChallenge.services.CommentService;

@RestController
@RequestMapping("/")
public class CommentRestController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("GET/comments/name/:{name}")
	public List<CommentModel> getCommentsByName(@PathVariable("name")String name){
		return commentService.getCommentsByName(name);
	}

}
