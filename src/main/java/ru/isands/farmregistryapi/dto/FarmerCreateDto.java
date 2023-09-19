package ru.isands.farmregistryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FarmerCreateDto {
    private String organizationName;

    private String organizationalForm;

    private Integer inn;

    private Integer kpp;

    private String ogrn;

    private Status status;

    private Long regionId;

    private Set<Long> cropAreas;
}
