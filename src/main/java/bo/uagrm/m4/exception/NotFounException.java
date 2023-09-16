
package bo.uagrm.m4.exception;

public class NotFounException extends RuntimeException{

    public NotFounException(String message) {
        super(message);
    }

    public NotFounException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
