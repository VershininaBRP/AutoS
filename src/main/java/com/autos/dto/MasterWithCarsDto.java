package com.autos.dto;

import java.util.List;

public class MasterWithCarsDto {
    private Long id;
    private String fullName;
    private String phone;
    private String specialty;
    private List<String> carModels;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public List<String> getCarModels() { return carModels; }
    public void setCarModels(List<String> carModels) { this.carModels = carModels; }
}