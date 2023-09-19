package ru.isands.farmregistryapi.entity;


import lombok.*;
import ru.isands.farmregistryapi.entity.enums.Status;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@Table(name = "regions")
public class Region extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
