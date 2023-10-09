package com.example.springboot.controller;

import com.example.springboot.common.BaseResponse;
import com.example.springboot.common.ErrorCode;
import com.example.springboot.common.JwtClaimsConstant;
import com.example.springboot.common.ResultUtils;
import com.example.springboot.domain.dto.UserLoginDTO;
import com.example.springboot.domain.dto.UserRegisterDTO;
import com.example.springboot.domain.entity.JwtProperties;
import com.example.springboot.domain.entity.User;
import com.example.springboot.domain.result.Result;
import com.example.springboot.domain.vo.UserLoginVO;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:8080",allowCredentials = "true")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

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


    /**
     * 更新用户信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/update")
    public Result<Integer> updateUser(@RequestBody User user) {
        // 1. 校验参数是否为空
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //2. 校验权限,可以获取用户登录信息
        User loginUser = userService.searchCurrent();
        //3. 触发更新
         userService.updateUser(user, loginUser);
        return Result.success();
    }

}
