package hamit.demir.utils;

import org.springframework.http.HttpStatus;

public record GenericResponse<T>(

        Boolean success,
        String message,
        String status,
        T data
) {
    public static <T> GenericResponse<T> error(String message, String status) {
        return new GenericResponse<>(false, message, status, null);
    }

    public static <T> GenericResponse<T> ok(T data) {
        return new GenericResponse<>(true, "Başarılı", HttpStatus.OK.toString(), data);
    }

}
