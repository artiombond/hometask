package com.github.artiombond.classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TrainBase {
    private Train[] trains = {
            new Train("Гомель",32434,LocalTime.of(9,55),3,4,45,4),
            new Train("Лондон",76486,LocalTime.of(11,30),23,34),
            new Train("Сан-Франциско",87478,LocalTime.of(14,7),66,34,2,4),
            new Train("Марсель",87478,LocalTime.of(20,23),66,34,2,4),
            new Train("Гомель",87475,LocalTime.of(11,14),23,0,0,3),
            new Train("Гродно",66661,LocalTime.of(20,21),22),
            new Train("Минск",66662,LocalTime.of(19,5),4),
            new Train("Минск",66663,LocalTime.of(23,0),1),
    };




    public ArrayList<Train> getTrainsByDestination(String destination) {
        ArrayList<Train> trainsByDestination = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().toLowerCase().equals(destination.toLowerCase())) {
                trainsByDestination.add(train);
            }
        }
        return trainsByDestination;
    }
    public ArrayList<Train> getTrainsByDestinationAndAfterTime(String destination, int hour){
        ArrayList<Train> trainsByDestinationAndAfterTime = new ArrayList<>();
        for(Train train:trains){
            if(train.getDestination().toLowerCase().equals(destination.toLowerCase()) && train.getDepartureTime().isAfter(LocalTime.of(hour,0))){
                trainsByDestinationAndAfterTime.add(train);
            }
        }
        return trainsByDestinationAndAfterTime;
    }
    public ArrayList<Train> getTrainsByDestinationAndCommonSeats(String destination){
        ArrayList<Train> trainsByDestinationAndCommonSeats = new ArrayList<>();
        for(Train train:trains){
            if(train.getDestination().toLowerCase().equals(destination.toLowerCase()) && train.getCommonSeats() > 0){
                trainsByDestinationAndCommonSeats.add(train);
            }
        }
        return trainsByDestinationAndCommonSeats;
    }

    @Override
    public String toString() {
        return Arrays.toString(trains) ;
    }
}