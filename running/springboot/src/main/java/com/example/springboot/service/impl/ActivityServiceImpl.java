package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springboot.domain.entity.Activity;
import com.example.springboot.domain.result.PageResult;
import com.example.springboot.mapper.ActivityMapper;
import com.example.springboot.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author 小拼音胖木木
* @description 针对表【activity】的数据库操作Service实现
* @createDate 2023-10-07 17:49:50
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 分页查询活动信息
     * 查询指定活动信息
     * @return
     */
    public PageResult getActivity() {
        IPage<Activity> page = new Page<>(1,3);
        QueryWrapper<Activity> wrapper = new QueryWrapper<>();
        wrapper.ge("time", LocalDateTime.now());
        wrapper.orderByDesc("time");
        activityMapper.selectPage(page,wrapper);
        return new PageResult(page.getTotal(),page.getRecords());
    }

    /**
     * 通过id获取活动信息
     * @param id
     * @return
     */
    public Activity getById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        return activity;
    }
}




