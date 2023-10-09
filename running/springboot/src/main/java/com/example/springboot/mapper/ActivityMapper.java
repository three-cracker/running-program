package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 小拼音胖木木
* @description 针对表【activity】的数据库操作Mapper
* @createDate 2023-10-07 17:49:50
* @Entity generator.domain.Activity
*/
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}




