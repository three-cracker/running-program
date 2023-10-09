package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.BaseContext;
import com.example.springboot.domain.entity.Comment;
import com.example.springboot.service.CommentService;
import com.example.springboot.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 小拼音胖木木
 * @description 针对表【comment】的数据库操作Service实现
 * @createDate 2023-10-02 17:35:17
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 发表评论
     *
     * @param comment
     */
    public Comment addComment(Comment comment) {
        //补全作者+时间+活动
        comment.setUserId(BaseContext.getCurrentId());
        comment.setCreateTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        comment.setPostId(comment.getPostId());
        comment.setContent(comment.getContent());
        comment.setActivityId(comment.getActivityId());
        this.save(comment);
        return comment;
    }

    /**
     * 更新评论
     *
     * @param comment
     */
    public void updateComment(Comment comment) {
        comment.setUpdateTime(LocalDateTime.now());
        commentMapper.updateById(comment);
    }


}




