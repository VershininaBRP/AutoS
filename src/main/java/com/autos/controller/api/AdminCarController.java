package com.autos.controller.api;

import com.autos.dto.CarDto;
import com.autos.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/cars")
public class AdminCarController {
    private final CarService carService;

    public AdminCarController(CarService carService) { this.carService = carService; }

    @GetMapping
    public List<CarDto> getAll() { return carService.findAllNotDeleted(); }

    @PostMapping
    public CarDto create(@RequestBody CarDto dto) { return carService.save(dto); }

    @PutMapping("/{id}")
    public CarDto update(@PathVariable Long id, @RequestBody CarDto dto) { return carService.update(id, dto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.softDelete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}