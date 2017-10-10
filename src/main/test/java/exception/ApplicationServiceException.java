package exception;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class ApplicationServiceException extends Exception {
    private String message;

    public ApplicationServiceException(){
        super("");
    }
    public ApplicationServiceException(String message) {
        super(message);
    }

    public ApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }



}
