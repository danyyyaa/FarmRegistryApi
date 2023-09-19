package ru.isands.farmregistryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.farmregistryapi.dto.FarmerChangeDto;
import ru.isands.farmregistryapi.dto.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.FarmerFullDto;
import ru.isands.farmregistryapi.dto.FarmerShortDto;
import ru.isands.farmregistryapi.entity.CropArea;
import ru.isands.farmregistryapi.entity.Farmer;
import ru.isands.farmregistryapi.entity.Region;
import ru.isands.farmregistryapi.entity.enums.Status;
import ru.isands.farmregistryapi.exception.NotFoundException;
import ru.isands.farmregistryapi.mapper.FarmerMapper;
import ru.isands.farmregistryapi.repository.CropAreaRepository;
import ru.isands.farmregistryapi.repository.FarmerRepository;
import ru.isands.farmregistryapi.repository.RegionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmerServiceImpl implements FarmerService {
    private final FarmerRepository farmerRepository;
    private final RegionRepository regionRepository;
    private final CropAreaRepository cropAreaRepository;
    private final FarmerMapper farmerMapper;

    @Override
    public Collection<FarmerShortDto> getFarmers(Pageable pageable) {
        return farmerRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(farmerMapper::toFarmerShortDto)
                .collect(Collectors.toList());
    }

    @Override
    public FarmerShortDto getFarmerById(Long farmerId) {
        Farmer farmer = farmerRepository.findById(farmerId).orElseThrow(() ->
                new NotFoundException(String.format("Farmer %s not found", farmerId)));

        return farmerMapper.toFarmerShortDto(farmer);
    }

    @Override
    @Transactional
    public FarmerFullDto createFarmer(FarmerCreateDto dto) {
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(() ->
                new NotFoundException(String.format("Region %s not found,", dto.getRegionId())));

        List<CropArea> cropAreas = cropAreaRepository.findAllById(dto.getCropAreas());

        if (!Objects.equals(dto.getCropAreas().size(), cropAreas.size())) {
            throw new NotFoundException("Some areas not found");
        }

        Farmer farmer = farmerRepository.save(farmerMapper.toFarmer(dto, region, cropAreas));

        return farmerMapper.toFarmerFullDto(farmer);
    }

    @Override
    @Transactional
    public FarmerFullDto changeFarmer(Long farmerId, FarmerChangeDto dto) {
        Farmer farmer = farmerRepository.findById(farmerId).orElseThrow(() ->
                new NotFoundException(String.format("Farmer %s not found", farmerId)));


        if (dto.getOrganizationName() != null) {
            farmer.setOrganizationName(dto.getOrganizationName());
        }
        if (dto.getOrganizationalForm() != null) {
            farmer.setOrganizationalForm(dto.getOrganizationalForm());
        }
        if (dto.getInn() != null) {
            farmer.setInn(dto.getInn());
        }
        if (dto.getKpp() != null) {
            farmer.setKpp(dto.getKpp());
        }
        if (dto.getOgrn() != null) {
            farmer.setOgrn(dto.getOgrn());
        }
        if (dto.getStatus() != null) {
            farmer.setStatus(dto.getStatus());
        }
        if (dto.getRegionId() != null) {
            Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(() ->
                    new NotFoundException(String.format("Region %s not found,", dto.getRegionId())));

            farmer.setRegion(region);
        }
        if (dto.getCropAreas() != null && !dto.getCropAreas().isEmpty()) {
            List<CropArea> cropAreas = cropAreaRepository.findAllById(dto.getCropAreas());

            if (!Objects.equals(dto.getCropAreas().size(), cropAreas.size())) {
                throw new NotFoundException("Some areas not found");
            }

            farmer.setCropAreas(cropAreas);
        }
        return farmerMapper.toFarmerFullDto(farmer);
    }

    @Override
    @Transactional
    public FarmerFullDto archive(Long farmerId) {
        Farmer farmer = farmerRepository.findById(farmerId).orElseThrow(() ->
                new NotFoundException(String.format("Farmer %s not found", farmerId)));

        farmer.setStatus(Status.ARCHIVED);

        return farmerMapper.toFarmerFullDto(farmerRepository.save(farmer));
    }
}
