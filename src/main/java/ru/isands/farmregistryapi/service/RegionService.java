package ru.isands.farmregistryapi.service;

import org.springframework.data.domain.Pageable;
import ru.isands.farmregistryapi.dto.RegionCreateDto;
import ru.isands.farmregistryapi.dto.RegionFullDto;
import ru.isands.farmregistryapi.dto.RegionShortDto;

import java.util.Collection;

public interface RegionService {
    Collection<RegionShortDto> getRegions(Pageable pageable);

    RegionFullDto createRegion(RegionCreateDto dto);

    RegionFullDto changeRegion(Long regionId, RegionShortDto dto);

    RegionFullDto archive(Long regionId);
}
