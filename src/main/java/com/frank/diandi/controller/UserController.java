package com.frank.diandi.controller;

import com.frank.diandi.common.Result;
import com.frank.diandi.dto.UserRegisterDTO;
import com.frank.diandi.entity.User;
import com.frank.diandi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2023/11/15
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO.getUserName().isBlank()) {
            return Result.failed("user name can't be empty", false);
        }
        if (userRegisterDTO.getPassword().isBlank()) {
            return Result.failed("password can't be empty", false);
        }

        userService.registerUser(userRegisterDTO);
        return null;
    }
}
