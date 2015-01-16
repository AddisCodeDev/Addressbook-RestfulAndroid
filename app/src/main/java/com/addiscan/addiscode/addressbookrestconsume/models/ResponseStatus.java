package com.addiscan.addiscode.addressbookrestconsume.models;

import java.util.List;

/**
 * Created by Abdu on 1/14/2015.
 */
public class ResponseStatus {
    public String ErrorCode;
    public String Message;
    public String StackTrace;
    public List<Error> Errors;

    public ResponseStatus(String errorCode, String message, String stackTrace, List<Error> errors) {
        ErrorCode = errorCode;
        Message = message;
        StackTrace = stackTrace;
        Errors = errors;
    }
}
