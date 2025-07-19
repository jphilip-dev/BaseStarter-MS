package com.jphilip.shared.domain.constant;

public final class HttpStatusCodes {

    public static final int OK = 200;
    public static final int NO_CONTENT = 204;

    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;

    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;

    private HttpStatusCodes() {}
}
