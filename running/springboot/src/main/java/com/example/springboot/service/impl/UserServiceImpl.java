package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.BaseContext;
import com.example.springboot.common.ErrorCode;
import com.example.springboot.domain.dto.UserLoginDTO;
import com.example.springboot.domain.dto.UserRegisterDTO;
import com.example.springboot.domain.entity.User;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
* @author 小拼音胖木木
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2023-10-02 14:14:04
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    public User login(UserLoginDTO userLoginDTO) {

        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        // 1. 校验
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
//        if (username.length() < 4) {
//            return null;
//        }
//        if (password.length() < 8) {
//            return null;
//        }

        // 2. 查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userLoginDTO.getUsername());
        queryWrapper.eq("password", userLoginDTO.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        //3. 匹配失败
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            return null;
        }


        //4. 匹配不成功返回一个报错信息
        return user;

    }

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    public void register(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        String password = userRegisterDTO.getPassword();
        //1. 校验
        if (StringUtils.isAnyBlank(username, password)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }

        // 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
        }

        //2. 执行注册功能，插入数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        this.save(user);
    }

    /**
     * 查询当前用户的所有信息
     * @return
     */
    public User searchCurrent() {
        System.out.println(BaseContext.getCurrentId());
        User user = userMapper.selectById(BaseContext.getCurrentId());
        user.setPassword("**********");
        if(user!=null){
            return user;
        }else{
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }

    }

    /**
     * 更新当前用户信息
     * @param user
     * @param loginUser
     * @return
     */
    public int updateUser(User user, User loginUser) {
        Long userId = user.getId();
            if (userId <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            // 2. 校验权限
            // 2.1 管理员可以更新任意信息
            // 2.2 用户只能更新自己的信息
            if ( !userId.equals(loginUser.getId())) {
                throw new BusinessException(ErrorCode.NO_AUTH);
        }
        User oldUser = this.getById(user.getId());
        if (oldUser == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        // 3. 触发更新
        return this.baseMapper.updateById(user);
    }
}




