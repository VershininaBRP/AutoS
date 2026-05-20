package com.autos.repository;

import com.autos.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Long> {
    List<Master> findAllByDeletedFalse();
    @Modifying @Transactional
    @Query("UPDATE Master m SET m.deleted = true WHERE m.id = ?1")
    void softDeleteById(Long id);
}