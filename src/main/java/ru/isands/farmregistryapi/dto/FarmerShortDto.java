package ru.isands.farmregistryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FarmerShortDto {
    private String organizationName;

    private RegionShortDto region;

    private List<CropAreaDto> cropAreas;
}
