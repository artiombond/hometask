package com.github.artiombond.collections.maintask.cars;

public class PassengerCar extends Car {

    private int passengersCapacity;
    private ComfortLevel comfortLevel;

    public PassengerCar(String carModel, int maxSpeed, int carPrice, int fuelConsumption, int passengersCapacity, ComfortLevel comfortLevel) {
        super(carModel, maxSpeed, carPrice, fuelConsumption);
        this.passengersCapacity = passengersCapacity;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("\n",
                ", passengersCapacity = " + passengersCapacity +
                        ", comfortLevel = " + comfortLevel +
                        '\n');
    }

}
