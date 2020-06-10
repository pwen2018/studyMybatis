package com.sven.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sven.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
