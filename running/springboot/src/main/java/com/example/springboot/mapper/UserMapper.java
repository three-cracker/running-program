package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.springboot.domain.entity.User;
/**
* @author 小拼音胖木木
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2023-10-02 15:01:50
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




