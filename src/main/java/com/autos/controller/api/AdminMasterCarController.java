package com.autos.controller.api;

import com.autos.entity.MasterCar;
import com.autos.service.MasterCarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/master-cars")
public class AdminMasterCarController {
    private final MasterCarService masterCarService;
    public AdminMasterCarController(MasterCarService masterCarService) { this.masterCarService = masterCarService; }

    @GetMapping
    public List<MasterCar> getAll() { return masterCarService.findAll(); }

    @PostMapping
    public void add(@RequestParam Long masterId, @RequestParam Long carId) { masterCarService.addRelation(masterId, carId); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { masterCarService.deleteRelation(id); }
}