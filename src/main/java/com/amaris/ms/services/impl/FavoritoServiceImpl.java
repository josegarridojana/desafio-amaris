/*
 * @(#)FavoritoServiceImpl.java
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
package com.amaris.ms.services.impl;

import com.amaris.ms.entities.Favorito;
import com.amaris.ms.exceptions.SimpleException;
import com.amaris.ms.repositories.FavoritoRepository;
import com.amaris.ms.services.FavoritoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * FavoritoServiceImpl.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class FavoritoServiceImpl implements FavoritoService {

    /** usuarioRepository. */
    private final FavoritoRepository favoritoRepository;

    @Override
    public List<Favorito> getAlls() {
        try {
            return this.favoritoRepository.findAll();
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de favoritos", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public List<Favorito> getAllByTitulo(final String titulo) {
        try {
            final List<Favorito> favoritos = new ArrayList<>();
            this.favoritoRepository.findByTituloContaining(titulo).forEach(favoritos::add);
            return favoritos;
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de favoritos por titulo", HttpStatus.BAD_REQUEST
                .value(), ex);
        }
    }

    @Override
    public Favorito getById(final long id) {
        try {
            final Optional<Favorito> pruebaData = this.favoritoRepository.findById(id);
            if (!pruebaData.isPresent()) {
                throw new SimpleException("Favorito no encontrado", HttpStatus.BAD_REQUEST.value());
            }
            return pruebaData.get();
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de usuarios por id", HttpStatus.BAD_REQUEST.value(),
                ex);
        }

    }

    @Override
    public Favorito create(final Favorito favorito) {
        try {
            final Optional<Favorito> findTitulo = this.favoritoRepository.findByTitulo(favorito.getTitulo());
            if (findTitulo.isPresent()) {
                throw new SimpleException("El titulo ya registrado", HttpStatus.BAD_REQUEST.value());
            }
            final Favorito saveFavorito = new Favorito();
            saveFavorito.setTitulo(favorito.getTitulo());
            saveFavorito.setDescripcion(favorito.getDescripcion());
            saveFavorito.setFecha(new Date());
            saveFavorito.setUsuario(favorito.getUsuario());
            return this.favoritoRepository
                .save(saveFavorito);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear favoritos", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public Favorito update(final long id, final Favorito favorito) {
        try {
            final Optional<Favorito> usuarioData = this.favoritoRepository.findById(id);
            if (!usuarioData.isPresent()) {
                throw new SimpleException("Usuario no actualizado", HttpStatus.BAD_REQUEST.value());
            }
            final Favorito saveFavorito = usuarioData.get();
            saveFavorito.setTitulo(favorito.getTitulo());
            saveFavorito.setDescripcion(favorito.getDescripcion());
            saveFavorito.setFecha(new Date());
            saveFavorito.setUsuario(favorito.getUsuario());
            return this.favoritoRepository.save(saveFavorito);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear favoritos", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> delete(final long id) {
        try {
            this.favoritoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear favoritos", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAlls() {
        try {
            this.favoritoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (final Exception ex) {
            throw new SimpleException("Error al crear favoritos", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

}
