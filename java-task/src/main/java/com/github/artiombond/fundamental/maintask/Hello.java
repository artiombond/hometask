package com.github.artiombond.fundamental.maintask;

import java.util.Scanner;

public class Hello {
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = input.nextLine();
        System.out.println("Привет " + name);

    }
}

