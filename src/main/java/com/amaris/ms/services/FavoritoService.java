/*
 * @(#)FavoritoService.java
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
package com.amaris.ms.services;

import com.amaris.ms.entities.Favorito;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * FavoritoService.
 *
 * @author Jose.
 * @version 1.0.0
 */
public interface FavoritoService {

    List<Favorito> getAlls();

    List<Favorito> getAllByTitulo(String titulo);

    Favorito getById(long id);

    Favorito create(Favorito favorito);

    Favorito update(long id, Favorito favorito);

    ResponseEntity<HttpStatus> delete(long id);

    ResponseEntity<HttpStatus> deleteAlls();

}
