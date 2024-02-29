/*
 * @(#)FavoritoController.java
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

import com.amaris.ms.entities.Favorito;
import com.amaris.ms.services.FavoritoService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FavoritoController.
 *
 * @author Jose.
 * @version 1.0.0
 */
@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping(path = "/favoritos", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoritoController {

    /** favoritoService. */
    @Autowired
    FavoritoService favoritoService;

    @Operation(description = "Obtiene favoritos.")
    @GetMapping
    public List<Favorito> getAllFavoritos() {
        return this.favoritoService.getAlls();
    }

    @GetMapping("/por-titulo")
    public List<Favorito> getAllByTitulo(@RequestParam(required = false) final String titulo) {
        return this.favoritoService.getAllByTitulo(titulo);
    }

    @GetMapping("/{id}")
    public Favorito getById(@PathVariable("id") final long id) {
        return this.favoritoService.getById(id);
    }

    @PostMapping
    public Favorito create(@RequestBody final Favorito favorito) {
        return this.favoritoService.create(favorito);
    }

    @PutMapping("/{id}")
    public Favorito update(@PathVariable("id") final long id,
        @RequestBody final Favorito favorito) {
        return this.favoritoService.update(id, favorito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") final long id) {
        return this.favoritoService.delete(id);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllUsuarios() {
        return this.favoritoService.deleteAlls();
    }

}
