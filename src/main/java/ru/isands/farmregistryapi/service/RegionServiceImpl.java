package ru.isands.farmregistryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.farmregistryapi.dto.region.RegionChangeDto;
import ru.isands.farmregistryapi.dto.region.RegionCreateDto;
import ru.isands.farmregistryapi.dto.region.RegionFullDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.entity.Farmer;
import ru.isands.farmregistryapi.entity.Region;
import ru.isands.farmregistryapi.entity.enums.Status;
import ru.isands.farmregistryapi.exception.NotFoundException;
import ru.isands.farmregistryapi.exception.ValidationException;
import ru.isands.farmregistryapi.mapper.RegionMapper;
import ru.isands.farmregistryapi.repository.FarmerRepository;
import ru.isands.farmregistryapi.repository.RegionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final FarmerRepository farmerRepository;
    private final RegionMapper regionMapper;

    @Override
    public Collection<RegionShortDto> getRegions(Pageable pageable) {
        return regionRepository.findAllByStatus(pageable, Status.ACTIVE)
                .stream()
                .map(regionMapper::toRegionShortDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RegionFullDto createRegion(RegionCreateDto dto) {
        List<Farmer> farmers = farmerRepository.findAllById(dto.getFarmerIds());

        if (!Objects.equals(farmers.size(), dto.getFarmerIds().size())) {
            throw new NotFoundException("Some farmers not found");
        }

        Region region = regionRepository.save(regionMapper.toRegion(dto, farmers));

        return regionMapper.toRegionFullDto(region);
    }

    @Override
    @Transactional
    public RegionFullDto changeRegion(Long regionId, RegionChangeDto dto) {
        Region region = regionRepository.findById(regionId).orElseThrow(() ->
                new NotFoundException(String.format("Region %s not found", regionId)));

        if (dto.getName() != null) {
            region.setName(dto.getName());
        }
        if (dto.getCode() != null) {
            region.setCode(dto.getCode());
        }
        if (dto.getStatus() != null) {
            region.setStatus(dto.getStatus());
        }
        return regionMapper.toRegionFullDto(regionRepository.save(region));
    }

    @Override
    @Transactional
    public RegionFullDto archive(Long regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow(() ->
                new NotFoundException(String.format("Region %s not found", regionId)));

        if (region.getStatus().equals(Status.ARCHIVED)) {
            throw new ValidationException(String.format("Region %s is already in the archive", regionId));
        }

        List<Farmer> farmers = farmerRepository.findAllByRegionIdAndStatus(regionId, Status.ACTIVE);

        return regionMapper.toRegionFullDto(region, farmers);
    }
}
