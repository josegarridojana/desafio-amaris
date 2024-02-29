/*
 * @(#)Result.java
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
package com.amaris.ms.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Result.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /** id */
    private Integer id;
    /** title */
    private String title;
    /** url */
    private String url;
    /** imageUrl */
    @JsonProperty("image_url")
    private String imageUrl;
    /** newsSite */
    @JsonProperty("news_site")
    private String newsSite;
    /** summary */
    private String summary;
    @JsonProperty("published_at")
    /** publishedAt */
    private Date publishedAt;
    /** updatedAt */
    @JsonProperty("updated_at")
    private Date updatedAt;
    /** featured */
    private boolean featured;
    /** launches */
    private List<Launche> launches;
    /** events */
    private List<Event> events;

}
