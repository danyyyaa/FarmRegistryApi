package ru.isands.farmregistryapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.isands.farmregistryapi.entity.Farmer;
import ru.isands.farmregistryapi.entity.enums.Status;

import java.util.List;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    @Query("SELECT f" +
            " FROM Farmer f" +
            " WHERE f.status = :status")
    List<Farmer> findAllByStatus(Pageable pageable, @Param("status") Status status);

    @Query("SELECT f" +
            " FROM Farmer f" +
            " WHERE f.status = :status" +
            " AND f.id = :id")
    Optional<Farmer> findByIdAndStatus(@Param("id") Long id, @Param("status") Status status);

    @Query("SELECT f FROM Farmer f WHERE f.status = :status AND f.region.id = :regionId")
    List<Farmer> findAllByRegionIdAndStatus(@Param("regionId") Long regionId, @Param("status") Status status);
}
