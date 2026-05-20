package com.autos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "master_car")
public class MasterCar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private Master master;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public MasterCar() {}
    // getters/setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Master getMaster() { return master; }
    public void setMaster(Master master) { this.master = master; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}