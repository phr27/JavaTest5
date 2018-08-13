package com.hand.infra.mapper;

import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FilmMapper extends Mapper<Film> {

    List<Film> selectByPage(@Param("page") Page page);
}
