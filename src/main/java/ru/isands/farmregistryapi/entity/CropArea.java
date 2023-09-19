package ru.isands.farmregistryapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@Table(name = "crop_area")
public class CropArea extends BaseEntity {
    private String name;
}
