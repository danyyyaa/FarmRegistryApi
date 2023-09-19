package ru.isands.farmregistryapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.farmregistryapi.aspect.ToLog;
import ru.isands.farmregistryapi.dto.FarmerChangeDto;
import ru.isands.farmregistryapi.dto.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.FarmerFullDto;
import ru.isands.farmregistryapi.dto.FarmerShortDto;
import ru.isands.farmregistryapi.service.FarmerService;
import ru.isands.farmregistryapi.util.OffsetBasedPageRequest;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

import static ru.isands.farmregistryapi.util.Constant.PAGE_DEFAULT_FROM;
import static ru.isands.farmregistryapi.util.Constant.PAGE_DEFAULT_SIZE;

@RestController
@RequestMapping("/farmer")
@RequiredArgsConstructor
@Validated
@ToLog
public class FarmerController {
    private final FarmerService farmerService;

    @GetMapping
    public Collection<FarmerShortDto> getFarmers(@RequestParam(defaultValue = PAGE_DEFAULT_FROM) @PositiveOrZero Integer from,
                                                 @RequestParam(defaultValue = PAGE_DEFAULT_SIZE) @Positive Integer size) {
        Pageable pageable = new OffsetBasedPageRequest(from, size);
        return farmerService.getFarmers(pageable);
    }

    @GetMapping("/{farmerId}")
    public FarmerShortDto getFarmerById(@Positive @PathVariable Long farmerId) {
        return farmerService.getFarmerById(farmerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmerFullDto createFarmer(@Valid @RequestBody FarmerCreateDto dto) {
        return farmerService.createFarmer(dto);
    }

    @PatchMapping("/{farmerId}")
    public FarmerFullDto changeFarmer(@Positive @PathVariable Long farmerId,
                                      @RequestBody FarmerChangeDto dto) {
        return farmerService.changeFarmer(farmerId, dto);
    }

    @PatchMapping("/{farmerId}/archive")
    public FarmerFullDto archive(@Positive @PathVariable Long farmerId) {
        return farmerService.archive(farmerId);
    }
}
