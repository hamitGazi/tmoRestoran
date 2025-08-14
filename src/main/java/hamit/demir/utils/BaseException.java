package hamit.demir.utils;

public class BaseException extends RuntimeException {
    BaseException() {
    }

    public BaseException(GenericResponse genericResponse) {
        super(genericResponse.message());
    }

}
