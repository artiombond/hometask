package com.github.artiombond.collections.maintask.cars;

public abstract class Car {
    private String carModel;
    private int maxSpeed;
    private int carPrice;
    private int fuelConsumption;

    public Car(String carModel, int maxSpeed, int carPrice, int fuelConsumption) {
        this.carModel = carModel;
        this.maxSpeed = maxSpeed;
        this.carPrice = carPrice;
        this.fuelConsumption = fuelConsumption;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "" +
                "carModel= " + carModel +
                ", maxSpeed = " + maxSpeed +
                ", carPrice = " + carPrice +
                ", fuelConsumption = " + fuelConsumption +
                '\n';
    }

}
