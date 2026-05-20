package com.autos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @Column(name = "unique_number", unique = true)
    private String uniqueNumber;
    private boolean deleted = false;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore   // <-- добавить
    private List<MasterCar> masterCars = new ArrayList<>();

    // constructors, getters, setters (обязательно)
    public Car() {}
    // геттеры/сеттеры...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getUniqueNumber() { return uniqueNumber; }
    public void setUniqueNumber(String uniqueNumber) { this.uniqueNumber = uniqueNumber; }
    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
    public List<MasterCar> getMasterCars() { return masterCars; }
    public void setMasterCars(List<MasterCar> masterCars) { this.masterCars = masterCars; }
}