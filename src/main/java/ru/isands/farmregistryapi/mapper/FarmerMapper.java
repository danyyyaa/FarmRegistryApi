package ru.isands.farmregistryapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.isands.farmregistryapi.dto.farmer.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerFullDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerShortDto;
import ru.isands.farmregistryapi.entity.CropArea;
import ru.isands.farmregistryapi.entity.Farmer;
import ru.isands.farmregistryapi.entity.Region;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface FarmerMapper {

    @Mapping(target = "status", source = "dto.status")
    @Mapping(target = "cropAreas", source = "cropAreas")
    Farmer toFarmer(FarmerCreateDto dto, Region region, Collection<CropArea> cropAreas);

    FarmerFullDto toFarmerFullDto(Farmer farmer);

    FarmerShortDto toFarmerShortDto(Farmer farmer);
}
