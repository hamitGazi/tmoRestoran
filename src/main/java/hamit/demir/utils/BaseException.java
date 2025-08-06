package hamit.demir.utils;

public class BaseException extends RuntimeException {
    BaseException() {
    }

    public BaseException(GenericRespose genericRespose) {
        super(genericRespose.message());
    }

}
