package com.autos.controller.api;

import com.autos.entity.Master;
import com.autos.service.MasterService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/masters")
public class AdminMasterController {
    private final MasterService masterService;
    public AdminMasterController(MasterService masterService) { this.masterService = masterService; }

    @GetMapping
    public List<Master> getAll() { return masterService.findAllNotDeleted(); }

    @PostMapping
    public Master create(@RequestBody Master master) { return masterService.save(master); }

    @PutMapping("/{id}")
    public Master update(@PathVariable Long id, @RequestBody Master master) { return masterService.update(id, master); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { masterService.softDelete(id); }
}