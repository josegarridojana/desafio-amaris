/*
 * @(#)NotiiciaMapper.java
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
package com.amaris.ms.mappers;

import com.amaris.ms.dtos.ArticleRs;
import com.amaris.ms.dtos.NoticiaRs;
import com.amaris.ms.dtos.Result;
import com.amaris.ms.dtos.ResultRs;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

/**
 * NotiiciaMapper.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Mapper
public interface NotiiciaMapper {

    // -------------------------------------------------------------------
    // -- Métodos Response -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Transforma de {@link ArticleRs} a {@link NoticiaRs} .
     *
     * @param response {@link ArticleRs}
     * @return {@link NoticiaRs}
     */
    @Mappings({
        @Mapping(target = "count", source = "count"),
        @Mapping(target = "results", source = "results")
    })
    NoticiaRs getResponse(ArticleRs response);

    /**
     * Convierte de Lista {@link Result} a Lista {@link ResultRs}
     *
     * @param rs Lista {@link Result}
     * @return Lista {@link ResultRs}
     */
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<ResultRs> getListResults(List<Result> rs);

    /**
     * Convierte de {@link Result} a {@link ResultRs}
     *
     * @param result {@link Result}
     * @return {@link ResultRs}
     */
    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "title", source = "title"),
        @Mapping(target = "newsSite", source = "newsSite"),
        @Mapping(target = "summary", source = "summary"),
        @Mapping(target = "publishedAt", source = "publishedAt"),
        @Mapping(target = "updatedAt", source = "updatedAt")
    })
    ResultRs getResults(Result result);

}
