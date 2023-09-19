package ru.isands.farmregistryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.farmregistryapi.dto.region.RegionCreateDto;
import ru.isands.farmregistryapi.dto.region.RegionFullDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.mapper.RegionMapper;
import ru.isands.farmregistryapi.repository.RegionRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    @Override
    public Collection<RegionShortDto> getRegions(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public RegionFullDto createRegion(RegionCreateDto dto) {
        return null;
    }

    @Override
    @Transactional
    public RegionFullDto changeRegion(Long regionId, RegionShortDto dto) {
        return null;
    }

    @Override
    @Transactional
    public RegionFullDto archive(Long regionId) {
        return null;
    }
}
