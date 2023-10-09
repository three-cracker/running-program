package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.entity.Activity;
import com.example.springboot.domain.result.PageResult;

/**
* @author 小拼音胖木木
* @description 针对表【activity】的数据库操作Service
* @createDate 2023-10-07 17:49:50
*/
public interface ActivityService extends IService<Activity> {
    PageResult getActivity();

    Activity getById(Integer id);
}
