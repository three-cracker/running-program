package com.example.springboot.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.example.springboot.domain.entity.Sign;
import com.example.springboot.domain.result.Result;
import com.example.springboot.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sign")
public class SignController {
    @Resource
    private SignService signService;

    // 新增或者更新
    // 新增或者更新
    @PostMapping("/addOrUpdate")
    public Result save(@RequestBody Sign sign) {
        if (sign.getId() == 0) {  // 新增打卡
            String today = DateUtil.today();
            QueryWrapper<Sign> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user", sign.getUser());
            queryWrapper.eq("time", today);
            Sign one = signService.getOne(queryWrapper);
            if (one != null) {  // 打过卡了
                return Result.error( "您已打过卡");
            }
            sign.setTime(today);
        }
        signService.saveOrUpdate(sign);
        return Result.success();
    }

}
