package com.example.springboot.service;

import com.example.springboot.domain.entity.Credit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.result.PageResult;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 小拼音胖木木
* @description 针对表【credit】的数据库操作Service
* @createDate 2023-10-02 14:13:58
*/
@Mapper
public interface CreditService extends IService<Credit> {

    /**
     * 查询所有用户的积分并排名
     * @return
     */
    PageResult selectPage();

    /**
     * 添加积分
     */
    void addCredit(Integer add);
}
