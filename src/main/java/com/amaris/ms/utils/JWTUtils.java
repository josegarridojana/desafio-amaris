/*
 * @(#)JWTUtils.java
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
package com.amaris.ms.utils;

import com.amaris.ms.constants.Constants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.UUID;

/**
 * JWTUtils.
 *
 * @author Jose.
 * @version 1.0.0
 */
public class JWTUtils {

    // -------------------------------------------------------------------
    // -- Constructor ----------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Constructor.
     */
    private JWTUtils() {
        throw new UnsupportedOperationException("Prohibido Instanciar esta clase");
    }

    /**
     * Genera un JWT simple.
     *
     * @param String username.
     * @return String.
     */
    public static String createJWT(final String username) {
        return JWT.create()
            .withIssuer(Constants.ISSUER)
            .withSubject(username)
            .withClaim(Constants.DATA_CLAIM, Constants.DATA)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + Constants.TOKEN_VALIDITY_IN_MILLIS))
            .withJWTId(UUID.randomUUID()
                .toString())
            .withNotBefore(new Date(System.currentTimeMillis() + 1000L))
            .sign(Algorithm.HMAC256(Constants.SECRET));
    }

}
