package ru.isands.farmregistryapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.isands.farmregistryapi.entity.Region;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("SELECT r" +
            " FROM Region r" +
            " WHERE r.status = :status")
    List<Region> findAllByStatus(Pageable pageable, @Param("status") Status status);
}
