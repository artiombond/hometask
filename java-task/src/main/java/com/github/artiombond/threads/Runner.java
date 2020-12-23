package com.github.artiombond.threads;

import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        Parking parking = new Parking(5);

        for (int i = 0; i < 10; i ++){
            new Car("Car " + i, parking).start();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
