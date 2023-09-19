package ru.isands.farmregistryapi.dto.farmer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.isands.farmregistryapi.dto.CropAreaDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FarmerShortDto {
    private Long id;

    private String organizationName;

    private RegionShortDto region;

    private List<CropAreaDto> cropAreas;
}
