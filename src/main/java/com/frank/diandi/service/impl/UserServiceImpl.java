package com.frank.diandi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.UserLoginDTO;
import com.frank.diandi.dto.UserRegisterDTO;
import com.frank.diandi.entity.User;
import com.frank.diandi.mapper.UserMapper;
import com.frank.diandi.service.UserService;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author frank
 * @date 2023/11/14
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Result<Boolean> registerUser(UserRegisterDTO userRegisterDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUserName, userRegisterDTO.getUserName());
        List<User> userList = userMapper.selectList(queryWrapper);
        if (!userList.isEmpty()) {
            return Result.failed("the same name already exists", false);
        }

        //generate salt
        String salt = UUID.randomUUID().toString().replace("-", "").substring(0, 15);

        String newPassword = userRegisterDTO.getPassword() + salt;

        //use md5 to encrypt password
        String finalPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());

        User user = new User();
        user.setUserName(userRegisterDTO.getUserName())
                .setPassword(finalPassword)
                .setSalt(salt)
                .setCreateBy(userRegisterDTO.getUserName())
                .setUpdateBy(userRegisterDTO.getUserName());
        int insertResult = userMapper.insert(user);

        if (insertResult == 1) {
            return Result.success("register user success", true);
        }

        return Result.failed("register user failed", false);
    }

    @Override
    public Result<User> loginUser(UserLoginDTO userLoginDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUserName, userLoginDTO.getUserName());
        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            String truePassword = user.getPassword();
            String loginPassword = DigestUtils.md5DigestAsHex((userLoginDTO.getPassword() + user.getSalt()).getBytes());

            if (loginPassword.equals(truePassword)) {
                return Result.success("login successful", user);
            }
            return Result.failed("login failed,please check your password",null);
        }

        return Result.failed("login failed,please check you user name", null);
    }

    @Override
    public Boolean logOutUser() {
        return null;
    }
}
