/*
 * @(#)NoticiaService.java
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

import com.amaris.ms.dtos.NoticiaRs;
import com.amaris.ms.dtos.ResultRs;
import java.util.List;

/**
 * NoticiaService.
 *
 * @author Jose.
 * @version 1.0.0
 */
public interface NoticiaService {

    List<ResultRs> getAlls();

    NoticiaRs getAllByTitulo(String titulo);

    NoticiaRs getAllNoticiaRecientes(int limit, int offSet);

    NoticiaRs getById(long id);

}
