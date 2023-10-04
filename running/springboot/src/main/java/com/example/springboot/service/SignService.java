package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.domain.entity.Sign;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    public Sign getOne(QueryWrapper<Sign> queryWrapper) {
        return null;
    }

    public void saveOrUpdate(Sign sign) {
    }
}
