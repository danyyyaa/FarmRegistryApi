package ru.isands.farmregistryapi.entity;


import lombok.*;
import ru.isands.farmregistryapi.entity.enums.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@Table(name = "farmers")
public class Farmer extends BaseEntity {

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "organization_form")
    private String organizationalForm;

    @Column(name = "inn")
    private Integer inn;

    @Column(name = "kpp")
    private Integer kpp;

    @Column(name = "ogrn")
    private String ogrn;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @ToString.Exclude
    private Region region;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "farmer_areas",
            joinColumns = @JoinColumn(name = "crop_area_id"),
            inverseJoinColumns = @JoinColumn(name = "farmer_id")
    )
    private List<CropArea> cropAreas = new ArrayList<>();
}
