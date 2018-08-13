package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.api.service.IFilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import com.hand.infra.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmMapper filmMapper;

    public List<Film> selectFilmsByPage(Page page) {
        return filmMapper.selectByPage(page);
    }

    public List<Film> selectFilmsWithPageHelper(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return filmMapper.selectAll();
    }
}
