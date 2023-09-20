package ru.isands.farmregistryapi.dto.farmer;

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
public class FarmerCreateDto {
    @Length(max = 255)
    @NotBlank
    private String organizationName;

    @Length(max = 255)
    @NotBlank
    private String organizationalForm;

    @NotNull
    private Integer inn;

    @NotNull
    private Integer kpp;

    @Length(max = 255)
    @NotBlank
    private String ogrn;

    @NotNull
    private Status status;

    private Long regionId;

    private Set<Long> cropAreas;
}
