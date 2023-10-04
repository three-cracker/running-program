package com.example.springboot.controller;

import com.example.springboot.common.JwtClaimsConstant;
import com.example.springboot.domain.dto.UserLoginDTO;
import com.example.springboot.domain.dto.UserRegisterDTO;
import com.example.springboot.domain.entity.JwtProperties;
import com.example.springboot.domain.entity.User;
import com.example.springboot.domain.result.Result;
import com.example.springboot.domain.vo.UserLoginVO;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("员工登录：{}", userLoginDTO);

        //
        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册：{}", userRegisterDTO);
        userService.register(userRegisterDTO);
        return Result.success();
    }

    @GetMapping("/searchCurrent")
    public Result sarchCurrent() {

        User user = userService.searchCurrent();
        return Result.success(user);

    }
}
