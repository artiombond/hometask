package com.github.artiombond.classes;

import java.util.Scanner;

public class Runner {
    public static void main( String[] args )
    {
        TrainBase trainBase = new TrainBase();
        Scanner input = new Scanner(System.in);
        System.out.println("Все поезда:\n " + trainBase.toString());
        System.out.println("Введите пункт назначения:\n");
        String destination = input.nextLine();
        System.out.println("Поезда следующие до пункта назначения "+ destination +":\n" + trainBase.getTrainsByDestination(destination) + "\n");
        System.out.println("Введите пункт назначения:\n");
        destination = input.nextLine();
        System.out.println("Введите после какого часа отправление:\n");
        String time = input.nextLine();
        System.out.println("Поезда следующие до пункта назначения "+ destination + " после " + time +"\n" + trainBase.getTrainsByDestinationAndAfterTime(destination, Integer.valueOf(time))+ "\n");
        System.out.println("Введите пункт назначения:\n");
        destination = input.nextLine();
        System.out.println("Поезда следующие до пункта назначения "+ destination + "со свободными общими местами" + ":\n" + trainBase.getTrainsByDestinationAndCommonSeats(destination)+ "\n");
    }
}
