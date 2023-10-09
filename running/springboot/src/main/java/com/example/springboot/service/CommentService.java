package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.entity.Comment;

/**
* @author 小拼音胖木木
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-10-02 17:35:17
*/
public interface CommentService extends IService<Comment> {

    /**
     * 发表评论
     *
     * @param comment
     */
    Comment addComment(Comment comment);

    /**
     * 更新评论
     * @param
     */
    void updateComment(Comment comment);

    Comment getCommentByActivityId(Long activityId);
}
