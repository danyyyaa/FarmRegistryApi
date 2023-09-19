package ru.isands.farmregistryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.farmregistryapi.entity.CropArea;

public interface CropAreaRepository extends JpaRepository<CropArea, Long> {
}
