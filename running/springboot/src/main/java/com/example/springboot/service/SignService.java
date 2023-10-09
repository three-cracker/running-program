package com.example.springboot.service;

import cn.hutool.crypto.asymmetric.Sign;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Service;

public interface SignService {

    void sign() throws JSONException;
}
