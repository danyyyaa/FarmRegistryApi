package ru.isands.farmregistryapi.dto.farmer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FarmerChangeDto {
    private Long id;

    @Length(max = 255)
    private String organizationName;

    @Length(max = 255)
    private String organizationalForm;

    private Integer inn;

    private Integer kpp;

    @Length(max = 255)
    private String ogrn;

    private Status status;

    private Long regionId;

    private Set<Long> cropAreas;
}
