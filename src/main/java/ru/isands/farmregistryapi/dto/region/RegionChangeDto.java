package ru.isands.farmregistryapi.dto.region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.isands.farmregistryapi.entity.enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegionChangeDto {
    @Length(max = 255)
    private String name;

    private Long code;

    private Status status;
}
