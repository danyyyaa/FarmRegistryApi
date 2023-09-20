package ru.isands.farmregistryapi.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.isands.farmregistryapi.entity.enums.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegionCreateDto {
    @Length(max = 255)
    @NotBlank
    private String name;

    @NotNull
    private Long code;

    @NotNull
    private Status status;

    private Set<Long> farmerIds;
}
