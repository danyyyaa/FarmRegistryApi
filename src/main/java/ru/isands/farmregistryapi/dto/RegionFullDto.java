package ru.isands.farmregistryapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

import static ru.isands.farmregistryapi.util.Constant.TIME_PATTERN;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegionFullDto {
    private Long id;

    @JsonFormat(pattern = TIME_PATTERN)
    private LocalDateTime created;

    @JsonFormat(pattern = TIME_PATTERN)
    private LocalDateTime updated;

    private String name;

    private Long code;

    private Status status;

    private List<FarmerShortDto> farmers;
}
