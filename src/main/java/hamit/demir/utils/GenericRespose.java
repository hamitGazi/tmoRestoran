package hamit.demir.utils;

import org.springframework.http.HttpStatus;

public record GenericRespose<T>(

        Boolean success,
        String message,
        String status,
        T data
) {
    public static <T> GenericRespose<T> error(String message, String status) {
        return new GenericRespose<>(false, message, status, null);
    }

    public static <T> GenericRespose<T> ok(T data) {
        return new GenericRespose<>(true, "Başarılı", HttpStatus.OK.toString(), data);
    }

}
