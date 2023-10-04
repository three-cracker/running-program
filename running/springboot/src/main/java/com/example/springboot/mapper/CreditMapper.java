package com.example.springboot.mapper;

import com.example.springboot.domain.entity.Credit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 小拼音胖木木
* @description 针对表【credit】的数据库操作Mapper
* @createDate 2023-10-02 14:13:58
* @Entity generator.domain.Credit
*/
@Mapper
public interface CreditMapper extends BaseMapper<Credit> {

}




