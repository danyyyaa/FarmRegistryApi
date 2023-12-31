package ru.isands.farmregistryapi.dto.farmer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.isands.farmregistryapi.dto.CropAreaDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

import static ru.isands.farmregistryapi.util.Constant.TIME_PATTERN;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FarmerFullDto {
    private Long id;

    @JsonFormat(pattern = TIME_PATTERN)
    private LocalDateTime created;

    @JsonFormat(pattern = TIME_PATTERN)
    private LocalDateTime updated;

    private String organizationName;

    private String organizationalForm;

    private Integer inn;

    private Integer kpp;

    private String ogrn;

    private Status status;

    private RegionShortDto region;

    private List<CropAreaDto> cropAreas;
}
