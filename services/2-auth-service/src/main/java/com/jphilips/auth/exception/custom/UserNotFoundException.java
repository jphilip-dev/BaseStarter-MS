package com.jphilips.auth.exception.custom;


import com.jphilip.shared.domain.exception.custom.AppException;
import com.jphilip.shared.domain.exception.errorcode.BaseErrorCode;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
