package ru.isands.farmregistryapi.service;

import org.springframework.data.domain.Pageable;
import ru.isands.farmregistryapi.dto.farmer.FarmerChangeDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerFullDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerShortDto;

import java.util.Collection;

public interface FarmerService {
    Collection<FarmerShortDto> getFarmers(Pageable pageable);

    FarmerShortDto getFarmerById(Long farmerId);

    FarmerFullDto createFarmer(FarmerCreateDto dto);

    FarmerFullDto changeFarmer(Long farmerId, FarmerChangeDto dto);

    FarmerFullDto archive(Long farmerId);
}
