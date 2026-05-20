package com.autos.service;

import com.autos.dto.MasterWithCarsDto;
import com.autos.entity.Master;
import com.autos.entity.MasterCar;
import com.autos.repository.MasterCarRepository;
import com.autos.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterService {
    @Autowired private MasterRepository masterRepository;
    @Autowired private MasterCarRepository masterCarRepository;

    public List<Master> findAllNotDeleted() {
        return masterRepository.findAllByDeletedFalse();
    }

    public Master save(Master master) {
        master.setDeleted(false);
        return masterRepository.save(master);
    }

    public Master update(Long id, Master masterData) {
        Master master = masterRepository.findById(id).orElseThrow();
        master.setFullName(masterData.getFullName());
        master.setPhone(masterData.getPhone());
        master.setSpecialty(masterData.getSpecialty());
        return masterRepository.save(master);
    }

    public void softDelete(Long id) {
        masterRepository.softDeleteById(id);
    }

    // Для пользователя: список мастеров + какие машины чинят
    public List<MasterWithCarsDto> findAllMastersWithCars() {
        List<Master> masters = masterRepository.findAllByDeletedFalse();
        return masters.stream().map(m -> {
            MasterWithCarsDto dto = new MasterWithCarsDto();
            dto.setId(m.getId());
            dto.setFullName(m.getFullName());
            dto.setPhone(m.getPhone());
            dto.setSpecialty(m.getSpecialty());
            List<String> carModels = masterCarRepository.findByMasterIdAndCar_DeletedFalse(m.getId())
                    .stream().map(mc -> mc.getCar().getModel() + " (" + mc.getCar().getUniqueNumber() + ")")
                    .collect(Collectors.toList());
            dto.setCarModels(carModels);
            return dto;
        }).collect(Collectors.toList());
    }
}