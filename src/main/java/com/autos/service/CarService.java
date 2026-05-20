package com.autos.service;

import com.autos.dto.CarDto;
import com.autos.entity.Car;
import com.autos.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired private CarRepository carRepository;

    public List<CarDto> findAllNotDeleted() {
        return carRepository.findAllByDeletedFalse().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CarDto save(CarDto dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setUniqueNumber(dto.getUniqueNumber());
        car.setDeleted(false);
        return toDto(carRepository.save(car));
    }

    public CarDto update(Long id, CarDto dto) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setModel(dto.getModel());
        car.setUniqueNumber(dto.getUniqueNumber());
        return toDto(carRepository.save(car));
    }

    public void softDelete(Long id) {
        carRepository.softDeleteById(id);
    }

    private CarDto toDto(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setUniqueNumber(car.getUniqueNumber());
        return dto;
    }
}