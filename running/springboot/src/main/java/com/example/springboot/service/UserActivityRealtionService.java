package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.entity.UserActivityRealtion;

/**
* @author 小拼音胖木木
* @description 针对表【user_activity_realtion】的数据库操作Service
* @createDate 2023-10-08 19:24:37
*/
public interface UserActivityRealtionService extends IService<UserActivityRealtion> {

    void join(Long activityid);
}
