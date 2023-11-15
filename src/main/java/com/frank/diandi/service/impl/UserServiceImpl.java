package com.frank.diandi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.diandi.entity.User;
import com.frank.diandi.mapper.UserMapper;
import com.frank.diandi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author frank
 * @date 2023/11/14
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Boolean registerUser(User user) {
        int i = userMapper.insert(user);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean loginUser() {
        return null;
    }

    @Override
    public Boolean logOutUser() {
        return null;
    }
}
