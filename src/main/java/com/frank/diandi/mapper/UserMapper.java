package com.frank.diandi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.diandi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
