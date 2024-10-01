package com.emp.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emp.demo.model.Comment;

@Service
public class CommentService {

    private final String COMMENTS_API_URL = "https://jsonplaceholder.typicode.com/comments";

    public List<Comment> getComments() {
        RestTemplate restTemplate = new RestTemplate();
        Comment[] commentsArray = restTemplate.getForObject(COMMENTS_API_URL, Comment[].class);
        
        System.out.println("Fetched comments count: " + (commentsArray != null ? commentsArray.length : 0));
        
        return Arrays.asList(commentsArray);
    }

}
