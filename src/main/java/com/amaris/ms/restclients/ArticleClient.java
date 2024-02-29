/*
 * @(#)ArticleClient.java
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
package com.amaris.ms.restclients;

import com.amaris.ms.aop.JsonProxyFeignClient;
import com.amaris.ms.dtos.ArticleRs;
import com.amaris.ms.enums.EnumError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ArticleClient.
 *
 * @author Jose.
 * @version 1.0.0
 */
// @FeignClient(name = "ArticleClient", url = "http://api.spaceflightnewsapi.net/v4")
@JsonProxyFeignClient(
    name = "ArticleClient",
    url = "${api.endpoints.spaceflightnewsapi}",
    error = EnumError.ERROR_ARTICLE)
public interface ArticleClient {

    // -------------------------------------------------------------------
    // -- Métodos Públicos -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Obtiene las noticias.
     *
     * @param limit {@link int}
     * @param offSet {@link int}
     * @return {@link ArticleRs}
     */
    @GetMapping(value = "/articles")
    ArticleRs geArticles(@RequestParam int limit, @RequestParam int offSet);
}
