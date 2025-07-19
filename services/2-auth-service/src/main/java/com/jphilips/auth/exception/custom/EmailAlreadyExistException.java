package com.jphilips.auth.exception.custom;


import com.jphilip.shared.domain.exception.custom.AppException;
import com.jphilip.shared.domain.exception.errorcode.BaseErrorCode;

public class EmailAlreadyExistException extends AppException {
    public EmailAlreadyExistException(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
