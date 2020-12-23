package com.github.artiombond.threads;

import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private String name;
    private Parking parking;
    private int parkingPlace;

    public Car(String name, Parking parking) {
        this.name = name;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting for place ");
            parkingPlace = parking.getPlace(200);
            System.out.println(name + " took place № " + parkingPlace);
            TimeUnit.MILLISECONDS.sleep(600);
        } catch (NoPlacesException | InterruptedException exception) {
            System.out.println(name + " go to another parking ");
        }finally {
            if (parkingPlace!= 0){
                parking.returnPlace(parkingPlace);
                System.out.println(name + " go away from place " + parkingPlace);
            }
        }
    }
}
