package ru.isands.farmregistryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegionCreateDto {
    private String name;
    private Long code;
    private Boolean archivalStatus;
    private Status status;
    private List<Long> farmerIds;
}
