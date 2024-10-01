package com.emp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emp.demo.model.Comment;
import com.emp.demo.service.CommentService;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public String getComments(Model model) {
        List<Comment> comments = commentService.getComments();
        
        comments.forEach(comment -> System.out.println(comment.getId() + " " + comment.getName()));
        
        model.addAttribute("comments", comments);

        return "comments";
    }

}
