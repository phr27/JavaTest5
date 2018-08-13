package com.hand.api.controller;

import com.hand.api.service.IFilmService;
import com.hand.domain.entity.Film;
import com.hand.domain.entity.Page;
import com.hand.infra.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/film")
    public ServerResponse<List<Film>> getFilmsInPage(Page page) {
        return ServerResponse.createOK(filmService.selectFilmsByPage(page));
    }

    @GetMapping("/film/pagehelper")
    public ServerResponse<List<Film>> getFilmsWithPageHelper(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return ServerResponse.createOK(filmService.selectFilmsWithPageHelper(page, pageSize));
    }
}
