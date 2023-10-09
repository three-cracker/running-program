package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.BaseContext;
import com.example.springboot.domain.entity.UserActivityRealtion;
import com.example.springboot.service.UserActivityRealtionService;
import com.example.springboot.mapper.UserActivityRealtionMapper;
import org.springframework.stereotype.Service;

/**
* @author 小拼音胖木木
* @description 针对表【user_activity_realtion】的数据库操作Service实现
* @createDate 2023-10-08 19:24:37
*/
@Service
public class UserActivityRealtionServiceImpl extends ServiceImpl<UserActivityRealtionMapper, UserActivityRealtion>
    implements UserActivityRealtionService{

    /**
     * 参加活动
     */
    public void join(Long activityId) {
        UserActivityRealtion realtion = new UserActivityRealtion();
        realtion.setActivityId(activityId);
        realtion.setUserId(BaseContext.getCurrentId());
        this.save(realtion);
    }
}




