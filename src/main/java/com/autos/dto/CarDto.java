package com.autos.dto;

public class CarDto {
    private Long id;
    private String model;
    private String uniqueNumber;
    // конструкторы, геттеры, сеттеры
    public CarDto() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getUniqueNumber() { return uniqueNumber; }
    public void setUniqueNumber(String uniqueNumber) { this.uniqueNumber = uniqueNumber; }
}