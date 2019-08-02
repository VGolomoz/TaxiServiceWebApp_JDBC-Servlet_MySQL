package com.robosh.model.entity;

import java.util.Objects;

public class Car {
    private int idCar;
    private String carNumber;
    private String brand;
    private String color;
    private String carType;

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", carNumber='" + carNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return idCar == car.idCar &&
                Objects.equals(carNumber, car.carNumber) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(color, car.color) &&
                Objects.equals(carType, car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCar, carNumber, brand, color, carType);
    }
}
