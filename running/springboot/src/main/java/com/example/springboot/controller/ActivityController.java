package com.example.springboot.controller;

import com.example.springboot.domain.entity.Activity;
import com.example.springboot.domain.entity.UserActivityRealtion;
import com.example.springboot.domain.result.PageResult;
import com.example.springboot.domain.result.Result;
import com.example.springboot.service.ActivityService;
import com.example.springboot.service.UserActivityRealtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserActivityRealtionService userActivityRealtionService;
    /**
     * 获取活动信息
     * @return
     */
    @GetMapping
    public Result<PageResult> getActivity(){
        PageResult pageResult = activityService.getActivity();
        return Result.success(pageResult);
    }

    /**
     * 通过id获取活动
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Activity> getById(@PathVariable Integer id){
        Activity activity = activityService.getById(id);
        return Result.success(activity);
    }

    /**
     * 参加活动
     * @param activityId
     * @return
     */
    @PostMapping
    public Result join(Long activityId){
        userActivityRealtionService.join(activityId);
        return Result.success();
    }


}
