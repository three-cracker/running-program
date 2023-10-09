package com.example.springboot.service;

import com.example.springboot.domain.dto.UserLoginDTO;
import com.example.springboot.domain.dto.UserRegisterDTO;
import com.example.springboot.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.vo.UserLoginVO;

/**
* @author 小拼音胖木木
* @description 针对表【user(用户信息)】的数据库操作Service
* @createDate 2023-10-02 14:14:04
*/
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    void register(UserRegisterDTO userRegisterDTO);

    /**
     * 查询当前用户的所有信息
     * @return
     */
    User searchCurrent();

    /**
     * 更新当前用户信息
     * @param user
     * @param loginUser
     * @return
     */
    int updateUser(User user, User loginUser);
}
