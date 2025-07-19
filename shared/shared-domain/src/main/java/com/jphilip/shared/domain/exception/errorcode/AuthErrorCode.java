package com.jphilip.shared.domain.exception.errorcode;

import com.jphilip.shared.domain.constant.HttpStatusCodes;
import lombok.Getter;

@Getter
public enum AuthErrorCode implements BaseErrorCode {

    FORBIDDEN(HttpStatusCodes.FORBIDDEN),
    UNAUTHORIZED(HttpStatusCodes.UNAUTHORIZED),

    OTP_MISMATCH(HttpStatusCodes.FORBIDDEN),

    USER_NOT_FOUND(HttpStatusCodes.NOT_FOUND),
    EMAIL_EXISTS(HttpStatusCodes.BAD_REQUEST),
    OWNERSHIP_MISMATCH(HttpStatusCodes.FORBIDDEN),
    PASSWORD_MISMATCH(HttpStatusCodes.BAD_REQUEST),
    USER_INACTIVE(HttpStatusCodes.BAD_REQUEST),

    JWT_MISSING(HttpStatusCodes.FORBIDDEN),
    JWT_EXPIRED(HttpStatusCodes.FORBIDDEN),
    JWT_INVALID(HttpStatusCodes.FORBIDDEN);

    private final int statusCode;
    private final String code;

    private static final String PREFIX = "AUTH_ERROR_";

    AuthErrorCode(int statusCode) {
        this.statusCode = statusCode;
        this.code = PREFIX + this.name();
    }

}
