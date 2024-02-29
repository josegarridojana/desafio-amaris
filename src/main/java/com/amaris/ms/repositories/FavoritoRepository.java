/*
 * @(#)FavoritoRepository.java
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
package com.amaris.ms.repositories;

import com.amaris.ms.entities.Favorito;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FavoritoRepository.
 *
 * @author Jose.
 * @version 1.0.0
 */
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    List<Favorito> findByTituloContaining(String titulo);

    Optional<Favorito> findByTitulo(String titulo);

}
