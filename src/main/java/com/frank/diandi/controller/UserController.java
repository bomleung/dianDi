package com.frank.diandi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frank.diandi.common.Result;
import com.frank.diandi.common.ResultCode;
import com.frank.diandi.dto.UserLoginDTO;
import com.frank.diandi.dto.UserRegisterDTO;
import com.frank.diandi.entity.User;
import com.frank.diandi.service.UserService;
import com.frank.diandi.util.JwtUtil;
import com.frank.diandi.vo.LoginVo;
import io.jsonwebtoken.Claims;
import lombok.Getter;
import org.checkerframework.checker.index.qual.LengthOf;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2023/11/15
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO.getUserName().isBlank()) {
            return Result.failed("user name can't be empty", false);
        }
        if (userRegisterDTO.getPassword().isBlank()) {
            return Result.failed("password can't be empty", false);
        }

        return userService.registerUser(userRegisterDTO);
    }

    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getUserName().isBlank()) {
            return Result.failed("user name can't be empty", null);
        }
        if (userLoginDTO.getPassword().isBlank()) {
            return Result.failed("password can't be empty", null);
        }

        Result<User> loginResult = userService.loginUser(userLoginDTO);

        if (loginResult.getCode().equals(ResultCode.FAILED.getCode())) {
            String resultMessage = loginResult.getMessage();
            return Result.failed(resultMessage, null);
        }

        String jwt = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jwt = jwtUtil.createJwt(mapper.writeValueAsString(loginResult.getData()));
        } catch (Exception e) {
            return Result.failed("login failed", null);
        }

        LoginVo loginVo = new LoginVo();
        loginVo.setUserName(userLoginDTO.getUserName());
        loginVo.setToken(jwt);

        return Result.success("login success", loginVo);

    }

    @GetMapping("/checkUserToken")
    public Result<User> checkToken(@RequestHeader(value = "token", required = false) String token) {
        if (token == null) {
            return Result.failed("user hadn't login in", null);
        }

        User tokenUserInfo = null;
        Claims claims = jwtUtil.parseJwt(token);
        String subject = claims.getSubject();
        try {
            tokenUserInfo = new ObjectMapper().readValue(subject, User.class);
        } catch (JsonProcessingException e) {
            return Result.failed("parse token failed", null);
        }
        if (tokenUserInfo != null) {
            return Result.success("user had login", tokenUserInfo);
        } else {
            return Result.failed("user hadn't login in", null);
        }
    }
}
