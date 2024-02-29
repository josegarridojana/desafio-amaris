/*
 * @(#)ResultRs.java
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

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ResultRs.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultRs {

    /** id */
    private Integer id;
    /** title */
    private String title;
    /** newsSite */
    private String newsSite;
    /** summary */
    private String summary;
    /** publishedAt */
    private Date publishedAt;
    /** updatedAt */
    private Date updatedAt;

}
