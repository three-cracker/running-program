package com.example.springboot.service;

import cn.hutool.crypto.asymmetric.Sign;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    public Sign getOne(QueryWrapper<Sign> queryWrapper) {
        return null;
    }

    public void saveOrUpdate(Sign sign) {
    }
}
