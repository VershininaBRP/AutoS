package com.autos.repository;

import com.autos.entity.MasterCar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MasterCarRepository extends JpaRepository<MasterCar, Long> {
    List<MasterCar> findAllByMaster_DeletedFalseAndCar_DeletedFalse();
    List<MasterCar> findByMasterIdAndCar_DeletedFalse(Long masterId);
}