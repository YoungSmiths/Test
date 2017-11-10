package cn.young.test;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-6 下午2:35
 */
public class EmailExeception extends RuntimeException {
    public EmailExeception() {
    }

    public EmailExeception(String message) {
        super(message);
    }

    public EmailExeception(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailExeception(Throwable cause) {
        super(cause);
    }

    public EmailExeception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
