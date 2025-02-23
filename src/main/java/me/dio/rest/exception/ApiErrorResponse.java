package me.dio.rest.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ApiErrorResponse {

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private final OffsetDateTime timestamp;
    private final int status;
    private final String message;
    private final String path;

    public ApiErrorResponse(HttpStatus status, String message, String path) {
        this.timestamp = OffsetDateTime.now(ZoneOffset.UTC);
        this.status = status.value();
        this.message = message != null ? message : status.name();
        this.path = path;
    }
}
