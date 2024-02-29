/*
 * @(#)NoticiaController.java
 *
 * Copyright (c) (Chile). All rights reserved.
 *
 * All rights to this product are owned by and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.amaris.ms.controllers;

import com.amaris.ms.dtos.NoticiaRs;
import com.amaris.ms.dtos.ResultRs;
import com.amaris.ms.services.NoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoticiaController.
 *
 * @author Jose.
 * @version 1.0.0
 */
@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping(path = "/noticias", produces = MediaType.APPLICATION_JSON_VALUE)
public class NoticiaController {

    /** noticiaService. */
    @Autowired
    NoticiaService noticiaService;

    @GetMapping
    public List<ResultRs> getAllNoticias() {
        return this.noticiaService.getAlls();
    }

    @GetMapping("/recientes")
    public NoticiaRs getAllNoticiasRecientes(@RequestParam("limit") final int limit,
        @RequestParam("offSet") final int offSet) {
        return this.noticiaService.getAllNoticiaRecientes(limit, offSet);
    }

    @GetMapping("/por-titulo")
    public NoticiaRs getAllByTitulo(@RequestParam(required = false) final String titulo) {
        return this.noticiaService.getAllByTitulo(titulo);
    }

    @GetMapping("/{id}")
    public NoticiaRs getById(@PathVariable("id") final long id) {
        return this.noticiaService.getById(id);
    }

}
