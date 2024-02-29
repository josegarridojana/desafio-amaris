/*
 * @(#)NoticiaServiceImpl.java
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

import com.amaris.ms.dtos.NoticiaRs;
import com.amaris.ms.dtos.ResultRs;
import com.amaris.ms.exceptions.SimpleException;
import com.amaris.ms.mappers.NotiiciaMapper;
import com.amaris.ms.restclients.ArticleClient;
import com.amaris.ms.services.NoticiaService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
//import org.slf4j.CleanLogger;
//import org.slf4j.CleanLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * NoticiaServiceImpl.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private ArticleClient articleClient;
    /** notiiciaMapper. */
    private final NotiiciaMapper notiiciaMapper = Mappers.getMapper(
        NotiiciaMapper.class);

    @Override
    public List<ResultRs> getAlls() {
        try {
            final var noticiaRs = new NoticiaRs();
            final var articleRs = this.articleClient.geArticles(0, Integer.MAX_VALUE);
            final var rsMapper = this.notiiciaMapper.getResponse(articleRs);
            final var result = rsMapper.getResults().stream().sorted(Comparator.comparing(
                ResultRs::getUpdatedAt)
                .reversed()).skip(0).limit(3).collect(Collectors.toList());
            noticiaRs.setResults(result);
            return noticiaRs.getResults();
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de noticias", HttpStatus.BAD_REQUEST.value(), ex);
        }
    }

    @Override
    public NoticiaRs getAllByTitulo(final String titulo) {
        try {
            final var noticiaRs = new NoticiaRs();
            final var articleRs = this.articleClient.geArticles(0, Integer.MAX_VALUE);
            final var rsMapper = this.notiiciaMapper.getResponse(articleRs);
            final var result = rsMapper.getResults().stream().filter(e -> e.getSummary().equals(titulo)).sorted(
                Comparator
                    .comparing(
                        ResultRs::getUpdatedAt)
                    .reversed()).skip(0).limit(3).collect(Collectors.toList());
            noticiaRs.setResults(result);
            return noticiaRs;
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de noticias por titulo", HttpStatus.BAD_REQUEST
                .value(), ex);
        }
    }

    @Override
    public NoticiaRs getAllNoticiaRecientes(final int limit, final int offSet) {
        try {
            final var noticiaRs = new NoticiaRs();
            final var articleRs = this.articleClient.geArticles(limit, offSet);
            final var rsMapper = this.notiiciaMapper.getResponse(articleRs);
            final var result = rsMapper.getResults().stream().sorted(Comparator.comparing(
                ResultRs::getUpdatedAt)
                .reversed()).skip(0).limit(3).collect(Collectors.toList());
            noticiaRs.setResults(result);
            return noticiaRs;
        } catch (final Exception ex) {
            throw new SimpleException("Error", HttpStatus.BAD_REQUEST.value(), ex);
        }

    }

    @Override
    public NoticiaRs getById(final long id) {
        try {
            final var noticiaRs = new NoticiaRs();
            final var articleRs = this.articleClient.geArticles(0, Integer.MAX_VALUE);
            final var rsMapper = this.notiiciaMapper.getResponse(articleRs);
            final var result = rsMapper.getResults().stream().filter(e -> e.getId().equals(id)).sorted(Comparator
                .comparing(
                    ResultRs::getUpdatedAt)
                .reversed()).skip(0).limit(3).collect(Collectors.toList());
            noticiaRs.setResults(result);
            return noticiaRs;
        } catch (final Exception ex) {
            throw new SimpleException("Error al consultar listado de noticias por id", HttpStatus.BAD_REQUEST.value(),
                ex);
        }

    }

}
