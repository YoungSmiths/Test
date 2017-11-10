package cn.young.dev.test;

import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-14 下午4:45
 */
public class HttpOperationException extends Exception implements Serializable {

    private static final long serialVersionUID = 2451898589577451937L;

    private final int statusCode;
    private int code;

    public HttpOperationException(String message) {
        super(message);
        this.statusCode = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }

    public HttpOperationException(int statusCode, int code, String message) {
        super(message);
        this.statusCode = statusCode;
        this.code = code;
    }

    public HttpOperationException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public HttpOperationException(String message, Throwable cause) {
        this(HttpStatus.SC_INTERNAL_SERVER_ERROR, message, cause);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getCode() {
        return code;
    }
}