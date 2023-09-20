package ru.isands.farmregistryapi.mapper;

import org.mapstruct.Mapper;
import ru.isands.farmregistryapi.dto.region.RegionCreateDto;
import ru.isands.farmregistryapi.dto.region.RegionFullDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.entity.Farmer;
import ru.isands.farmregistryapi.entity.Region;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    RegionShortDto toRegionShortDto(Region region);

    RegionFullDto toRegionFullDto(Region region, Collection<Farmer> farmers);

    RegionFullDto toRegionFullDto(Region region);

    Region toRegion(RegionCreateDto dto, Collection<Farmer> farmers);
}
