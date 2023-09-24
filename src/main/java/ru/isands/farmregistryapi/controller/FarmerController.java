package ru.isands.farmregistryapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.farmregistryapi.aspect.ToLog;
import ru.isands.farmregistryapi.dto.farmer.FarmerChangeDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerCreateDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerFullDto;
import ru.isands.farmregistryapi.dto.farmer.FarmerShortDto;
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
@Tag(name = "Farmer-controller")
public class FarmerController {
    private final FarmerService farmerService;

    @GetMapping
    @Operation(summary = "get all farmers")
    public Collection<FarmerShortDto> getFarmers(@RequestParam(defaultValue = PAGE_DEFAULT_FROM) @Parameter @PositiveOrZero Integer from,
                                                 @RequestParam(defaultValue = PAGE_DEFAULT_SIZE) @Parameter @Positive Integer size) {
        Pageable pageable = new OffsetBasedPageRequest(from, size);
        return farmerService.getFarmers(pageable);
    }

    @GetMapping("/{farmerId}")
    @Operation(summary = "get farmer by id")
    public FarmerShortDto getFarmerById(@Positive @Parameter @PathVariable Long farmerId) {
        return farmerService.getFarmerById(farmerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "create farmer")
    public FarmerFullDto createFarmer(@Valid @RequestBody @Parameter FarmerCreateDto dto) {
        return farmerService.createFarmer(dto);
    }

    @PatchMapping("/{farmerId}")
    @Operation(summary = "change farmer")
    public FarmerFullDto changeFarmer(@Positive @PathVariable @Parameter Long farmerId,
                                      @RequestBody @Parameter FarmerChangeDto dto) {
        return farmerService.changeFarmer(farmerId, dto);
    }

    @PatchMapping("/{farmerId}/archive")
    @Operation(summary = "archive")
    public FarmerFullDto archive(@Positive @Parameter @PathVariable Long farmerId) {
        return farmerService.archive(farmerId);
    }
}
