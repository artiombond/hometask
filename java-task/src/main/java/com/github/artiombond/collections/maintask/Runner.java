package com.github.artiombond.collections.maintask;

import com.github.artiombond.collections.maintask.cars.Car;
import com.github.artiombond.collections.maintask.cars.ComfortLevel;
import com.github.artiombond.collections.maintask.cars.PassengerCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    static List<Car> cars = Arrays.asList(
            new PassengerCar("BMW 525", 230, 5000, 15, 4, ComfortLevel.COMFORTABLE),
            new PassengerCar("Audi 80", 160, 3000, 12, 4, ComfortLevel.ECONOMICAL),
            new PassengerCar("Cadillac CTS", 200, 28000, 17, 4, ComfortLevel.BUSINESS),
            new PassengerCar("Porshe 911", 290, 80000, 19, 4, ComfortLevel.BUSINESS),
            new PassengerCar("Gelly Atlas", 210, 11000, 11, 4, ComfortLevel.COMFORTABLE),
            new PassengerCar("Renault logan", 180, 2000, 8, 4, ComfortLevel.ECONOMICAL)
    );

    public static void main(String[] args) {
        CabCompany company = new CabCompany(cars);
        System.out.println("Общая стоимость автопарка:" + company.getTotalCostOfCars());
        System.out.println("Автомобили автопарка отсортированные по расходу топлива: \n" + company.sortByFuelConsumption().toString());
        Scanner input = new Scanner(System.in);
        System.out.println("Введите нижнюю границу скорости");
        int minSpeed = input.nextInt();
        System.out.println("Введите верхнюю границу скорости");
        int maxSpeed = input.nextInt();
        System.out.println("Автомобили со скоростями в диапозоне " + minSpeed+" - " + maxSpeed + ":\n" + company.getCarBySpeedRange(minSpeed, maxSpeed).toString());

    }
}