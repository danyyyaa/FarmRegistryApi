package ru.isands.farmregistryapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.farmregistryapi.aspect.ToLog;
import ru.isands.farmregistryapi.dto.region.RegionCreateDto;
import ru.isands.farmregistryapi.dto.region.RegionFullDto;
import ru.isands.farmregistryapi.dto.region.RegionShortDto;
import ru.isands.farmregistryapi.service.RegionService;
import ru.isands.farmregistryapi.util.OffsetBasedPageRequest;

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
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public Collection<RegionShortDto> getRegions(@RequestParam(defaultValue = PAGE_DEFAULT_FROM) @PositiveOrZero Integer from,
                                                 @RequestParam(defaultValue = PAGE_DEFAULT_SIZE) @Positive Integer size) {
        Pageable pageable = new OffsetBasedPageRequest(from, size);
        return regionService.getRegions(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegionFullDto createRegion(@Valid @RequestBody RegionCreateDto dto) {
        return regionService.createRegion(dto);
    }

    @PatchMapping("/{regionId}")
    public RegionFullDto changeRegion(@Positive @PathVariable Long regionId,
                                      @RequestBody RegionShortDto dto) {
        return regionService.changeRegion(regionId, dto);
    }

    @PatchMapping("/{regionId}/archive")
    public RegionFullDto archive(@Positive @PathVariable Long regionId) {
        return regionService.archive(regionId);
    }
}
