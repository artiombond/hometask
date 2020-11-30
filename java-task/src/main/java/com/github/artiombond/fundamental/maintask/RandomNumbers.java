package com.github.artiombond.fundamental.maintask;

import java.util.Scanner;

public class RandomNumbers {
    public static void main( String[] args )
    {
        double[] array;
        int number;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите кол-во случайных чисел: ");
        number = input.nextInt();
        array = new double[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
            System.out.println(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
