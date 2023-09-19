package ru.isands.farmregistryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.farmregistryapi.entity.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long>/*, QuerydslPredicateExecutor<Farmer> */ {
}
