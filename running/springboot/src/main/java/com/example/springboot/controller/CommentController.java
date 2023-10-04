package com.example.springboot.controller;

import com.example.springboot.domain.entity.Comment;
import com.example.springboot.domain.result.Result;
import com.example.springboot.mapper.CommentMapper;
import com.example.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;
    //发表评论
    @PostMapping
    public Result addComment(@RequestBody Comment comment){


        commentService.addComment(comment.getContent(),comment.getPostId());
        return Result.success();
    }

    //发表评论
    @PutMapping
    public Result update(@RequestBody Comment comment){

        commentService.updateComment(comment);
        return Result.success();
    }


    //删除评论
    @DeleteMapping()
    public Result delete(Long id){

        commentMapper.deleteById(id);
        return Result.success();
    }
}
