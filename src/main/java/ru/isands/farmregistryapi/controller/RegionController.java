package ru.isands.farmregistryapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.farmregistryapi.aspect.ToLog;
import ru.isands.farmregistryapi.dto.region.RegionChangeDto;
import ru.isands.farmregistryapi.dto.region.RegionCreateDto;
import ru.isands.farmregistryapi.dto.region.RegionFullDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.service.RegionService;
import ru.isands.farmregistryapi.util.OffsetBasedPageRequest;
import ru.isands.farmregistryapi.validator.ValuesAllowedConstraint;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

import static ru.isands.farmregistryapi.util.Constant.PAGE_DEFAULT_FROM;
import static ru.isands.farmregistryapi.util.Constant.PAGE_DEFAULT_SIZE;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
@Validated
@ToLog
@Tag(name = "Region-controller")
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    @Operation(summary = "get all regions")
    public Collection<RegionShortDto> getRegions(@RequestParam(defaultValue = PAGE_DEFAULT_FROM) @Parameter @PositiveOrZero Integer from,
                                                 @RequestParam(defaultValue = PAGE_DEFAULT_SIZE) @Parameter @Positive Integer size,
                                                 @ValuesAllowedConstraint(propName = "sort",
                                                         values = {"name", "code"}) @Parameter @RequestParam(value = "sort",
                                                         defaultValue = "code") String sort) {
        Pageable pageable = new OffsetBasedPageRequest(from, size, Sort.by(Sort.Direction.DESC, sort));
        return regionService.getRegions(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "create region")
    public RegionFullDto createRegion(@Valid @Parameter @RequestBody RegionCreateDto dto) {
        return regionService.createRegion(dto);
    }

    @PatchMapping("/{regionId}")
    @Operation(summary = "change region")
    public RegionFullDto changeRegion(@Positive @Parameter @PathVariable Long regionId,
                                      @RequestBody @Parameter RegionChangeDto dto) {
        return regionService.changeRegion(regionId, dto);
    }

    @PatchMapping("/{regionId}/archive")
    @Operation(summary = "archive")
    public RegionFullDto archive(@Positive @Parameter @PathVariable Long regionId) {
        return regionService.archive(regionId);
    }
}
