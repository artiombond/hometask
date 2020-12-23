package com.github.artiombond.threads;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private Semaphore semaphore;
    private ConcurrentLinkedQueue<Integer> places = new ConcurrentLinkedQueue<>();

    public Parking(int parkingSize) {
        semaphore = new Semaphore(parkingSize);
        for (int i = 1; i <= parkingSize; i++){
            places.add(i);
        }
    }

    public int getPlace(long maxWaitMillis) throws NoPlacesException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                return places.poll();
            }
        } catch (InterruptedException e) {
            throw new NoPlacesException(e);
        }
        throw new NoPlacesException("No places");
    }

    public void returnPlace(int placeNumber){
        places.add(placeNumber);
        semaphore.release();
    }

}
