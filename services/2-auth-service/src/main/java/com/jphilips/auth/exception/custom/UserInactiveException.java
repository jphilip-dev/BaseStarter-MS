package com.jphilips.auth.exception.custom;


import com.jphilip.shared.domain.exception.custom.AppException;
import com.jphilip.shared.domain.exception.errorcode.BaseErrorCode;

public class UserInactiveException extends AppException {
    public UserInactiveException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
