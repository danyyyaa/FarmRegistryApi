package ru.isands.farmregistryapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static ru.isands.farmregistryapi.util.Constant.TIME_PATTERN;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ApiError {
    private String message;
    private String reason;
    private String status;

    @JsonFormat(pattern = TIME_PATTERN)
    private LocalDateTime timestamp;
}
