package com.java.WChallenge.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.WChallenge.models.CommentModel;

@Service
public class CommentService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<CommentModel> getCommentsByName(String name){
		CommentModel[] comment = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?name=" + name, CommentModel[].class);
		List<CommentModel> comments = Arrays.asList(comment);
		return comments;
	}

}
