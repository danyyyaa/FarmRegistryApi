package ru.isands.farmregistryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.farmregistryapi.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long>/*, QuerydslPredicateExecutor<Region>*/ {
}
