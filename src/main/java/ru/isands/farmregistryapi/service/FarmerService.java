package ru.isands.farmregistryapi.service;

import org.springframework.data.domain.Pageable;
import ru.isands.farmregistryapi.dto.FarmerChangeDto;
import ru.isands.farmregistryapi.dto.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.FarmerFullDto;
import ru.isands.farmregistryapi.dto.FarmerShortDto;

import java.util.Collection;

public interface FarmerService {
    Collection<FarmerShortDto> getFarmers(Pageable pageable);

    FarmerShortDto getFarmerById(Long farmerId);

    FarmerFullDto createFarmer(FarmerCreateDto dto);

    FarmerFullDto changeFarmer(Long farmerId, FarmerChangeDto dto);

    FarmerFullDto archive(Long farmerId);
}
