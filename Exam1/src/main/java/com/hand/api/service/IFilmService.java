package com.hand.api.service;

import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;

import java.util.List;

public interface IFilmService {

    List<Film> selectFilmsByPage(Page page);

    List<Film> selectFilmsWithPageHelper(Integer page, Integer pageSize);
}
