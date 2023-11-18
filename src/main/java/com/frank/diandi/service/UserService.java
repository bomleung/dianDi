package com.frank.diandi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.UserRegisterDTO;
import com.frank.diandi.entity.User;

import javax.swing.text.StyledEditorKit;

/**
 * @author Frank
 */
public interface UserService extends IService<User> {

    /**
     * register a new User
     *
     * @param userRegisterDTO
     * @return ture-success false-failed
     */
    public Result<Boolean> registerUser(UserRegisterDTO userRegisterDTO);


    /**
     * user login
     *
     * @return ture-success false-failed
     */
    public Boolean loginUser();

    /**
     * user logout
     *
     * @return ture-success false-failed
     */
    public Boolean logOutUser();
}
