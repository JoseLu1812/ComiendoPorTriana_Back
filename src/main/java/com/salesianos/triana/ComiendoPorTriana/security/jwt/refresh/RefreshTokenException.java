package com.salesianos.triana.ComiendoPorTriana.security.jwt.refresh;

import com.salesianos.triana.ComiendoPorTriana.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {

    public RefreshTokenException(String msg) {
        super(msg);
    }
}
