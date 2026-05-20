package com.autos.controller.api;

import com.autos.dto.MasterWithCarsDto;
import com.autos.service.MasterService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user/masters")
public class UserMasterController {
    private final MasterService masterService;
    public UserMasterController(MasterService masterService) { this.masterService = masterService; }

    @GetMapping
    public List<MasterWithCarsDto> getAllMastersWithCars() {
        return masterService.findAllMastersWithCars();
    }
}