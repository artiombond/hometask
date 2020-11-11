package com.github.artiombond.collectionstask.maintask;

import com.github.artiombond.collectionstask.maintask.cars.Car;
import com.github.artiombond.collectionstask.maintask.cars.PassengerCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CabCompany {
    private List<? extends Car> cars;

    public List<PassengerCar> getPassangerCars(){
        List<PassengerCar> passengerCars = new ArrayList<>();
        for (Car car : cars) {if (car instanceof PassengerCar) {passengerCars.add((PassengerCar) car);}}
        return passengerCars;
    }

    public int getTotalCostOfCars(){
        int totalCost = 0;
        for (Car car:cars){
            totalCost += car.getCarPrice();
        }
        return totalCost;
    }

    public CabCompany sortByFuelConsumption(){
        Collections.sort(cars,(o1, o2) -> o1.getFuelConsumption()-o2.getFuelConsumption());
        return this;
    }

    public List<Car> getCarBySpeedRange(int minSpeed, int maxSpeed){
        List<Car> carsWithRangeSpeed = new ArrayList<>();
        for (Car car:cars){
            if (car.getMaxSpeed() > minSpeed && car.getMaxSpeed() < maxSpeed){
                carsWithRangeSpeed.add(car);
            }
        }
        return carsWithRangeSpeed;
    }

    public List<? extends Car> getCars() {
        return cars;
    }

    public CabCompany(List<? extends Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CabCompany{\n" + cars +
                '}';
    }

}
