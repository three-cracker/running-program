package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 小拼音胖木木
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2023-10-02 17:35:17
* @Entity generator.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}




