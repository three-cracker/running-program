package com.example.springboot.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.domain.entity.Sign;
import com.example.springboot.domain.result.Result;
import com.example.springboot.service.SignService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/sign")
public class SignController {
    @Resource
    private SignService signService;

    // 新增或者更新
    @PostMapping("/addOrUpdate")
    public Result sign() throws JSONException {

        signService.sign();
        return Result.success();
    }

}
