package com.github.artiombond.fundamental.maintask;

import java.util.Scanner;

public class MonthNumber {
    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main( String[] args ) {
        String inputString;
        int monthNumber;
        String monthString = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");

        while (true) {
            inputString = input.next();
            if (!isNumeric(inputString))
            {
                System.out.println("Некорректный номер. Повторите ввод");
                continue;
            }
            monthNumber = Integer.parseInt(inputString);
            if (monthNumber > 12 || monthNumber < 1) {
                System.out.println("Некорректный номер. Повторите ввод");
                continue;
            }else{
                break;
            }
        }
        switch (monthNumber) {
            case 1:
                monthString = "Январь";
                break;
            case 2:
                monthString = "Февраль";
                break;
            case 3:
                monthString = "Март";
                break;
            case 4:
                monthString = "Апрель";
                break;
            case 5:
                monthString = "Май";
                break;
            case 6:
                monthString = "Июнь";
                break;
            case 7:
                monthString = "Июль";
                break;
            case 8:
                monthString = "Август";
                break;
            case 9:
                monthString = "Сентябрь";
                break;
            case 10:
                monthString = "Октябрь";
                break;
            case 11:
                monthString = "Ноябрь";
                break;
            case 12:
                monthString = "Декабрь";
                break;
            default:
                System.out.println("Некоректный ввод");
        }
        System.out.println(monthString);
    }

}
