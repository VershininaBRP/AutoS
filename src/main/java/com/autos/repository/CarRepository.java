package com.autos.repository;

import com.autos.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByDeletedFalse();
    @Modifying
    @Transactional
    @Query("UPDATE Car c SET c.deleted = true WHERE c.id = ?1")
    void softDeleteById(Long id);
}