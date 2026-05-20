package com.autos.service;

import com.autos.entity.Car;
import com.autos.entity.Master;
import com.autos.entity.MasterCar;
import com.autos.repository.CarRepository;
import com.autos.repository.MasterCarRepository;
import com.autos.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterCarService {
    @Autowired private MasterCarRepository masterCarRepository;
    @Autowired private MasterRepository masterRepository;
    @Autowired private CarRepository carRepository;

    public List<MasterCar> findAll() {
        return masterCarRepository.findAllByMaster_DeletedFalseAndCar_DeletedFalse();
    }

    public void addRelation(Long masterId, Long carId) {
        Master master = masterRepository.findById(masterId).orElseThrow();
        Car car = carRepository.findById(carId).orElseThrow();
        if (master.isDeleted() || car.isDeleted()) throw new RuntimeException("Нельзя добавить удалённого мастера или машину");
        MasterCar mc = new MasterCar();
        mc.setMaster(master);
        mc.setCar(car);
        masterCarRepository.save(mc);
    }

    public void deleteRelation(Long relationId) {
        masterCarRepository.deleteById(relationId);
    }
}