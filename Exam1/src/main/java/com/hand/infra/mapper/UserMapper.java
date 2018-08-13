package com.hand.infra.mapper;

import com.hand.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    int countByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
