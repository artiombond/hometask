package com.github.artiombond.fundamental;

import java.util.*;

public class OptionalTask {

    public static int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static long getLongestNumber(long[] array) {
        long longestNumber = array[0];
        for (int i = 1; i < array.length; i ++){
            if (getCountsOfDigits(array[i]) > getCountsOfDigits(longestNumber) ){
                longestNumber = array[i];
            }
        }
        return longestNumber;
    }
    public static long getShortestNumber(long[] array) {
        long shortestNumber = array[0];
        for (int i = 1; i < array.length; i ++){
            if (getCountsOfDigits(array[i]) < getCountsOfDigits(shortestNumber) ){
                shortestNumber = array[i];
            }
        }
        return shortestNumber;
    }
    public static long[] sortByLength(long[] array){
        for (int i = 0; i < array.length; i++) {
            long min =  array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (getCountsOfDigits(array[j]) < getCountsOfDigits(min)) {
                    min = array[j];
                    minId = j;
                }
            }
            long temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }

        return array;
    }
    public static float getAverageLength(long[] array){
        float averageLength = 0;
        for(long number:array){
            averageLength += getCountsOfDigits(number);
        }
        return (averageLength == 0) ? 0 : averageLength / array.length;
    }
    public static long[] getItemsShorterThenAverage(long[] array){
        float length = getAverageLength(array);
        int numberOfItemsShorterThenAverageLength = 0;
        for(long number:array){
            if (getCountsOfDigits(number) < length){
                numberOfItemsShorterThenAverageLength++;
            }
        }
        long[] itemsShorterThenAverageLength = new long[numberOfItemsShorterThenAverageLength];
        for(int i = 0; i < array.length; i++){
            if (getCountsOfDigits(array[i]) < length){
                itemsShorterThenAverageLength[i] = array[i];
            }
        }
        return itemsShorterThenAverageLength;
    }
    public static long getNumberWithMinimalVariousDigits(long[] array){
        int numberOfItemWithMinVarDigits = 0;
        int countOfVariousDigits = 0;
        for (int i = 0; i < array.length; i++) {
            int countsOfDigitsTemp = getCountsOfDigits(array[i]);
            for (int j = 0; j < getCountsOfDigits(array[i]) - 1; j++) {
                long jDigit = array[i]/((long)Math.pow(10,j))%10;
                for (int k = j+1; k < getCountsOfDigits(array[i]); k++) {
                    long kDigit = array[i]/((long)Math.pow(10,k))%10;
                    if (jDigit == kDigit) {
                        countsOfDigitsTemp--;
                        break;
                    }
                }
            }
            if (i == 0){
                countOfVariousDigits = countsOfDigitsTemp;
            }
            if(countOfVariousDigits > countsOfDigitsTemp){
                numberOfItemWithMinVarDigits = i;
                countOfVariousDigits = countsOfDigitsTemp;
            }
        }
        return array[numberOfItemWithMinVarDigits];
    }

    public  static String arrayToString(long[] array){
        String arrayString = "";
        for (long item: array){
            arrayString += item + " ";
        }
        return arrayString;
    }

    public static void main( String[] args )
    {
        float length = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во чисел: ");
        int num = in.nextInt();
        long[] array = new long[num];
        System.out.println("Введите числа: ");
        for(int i = 0; i < num; i++){
            array[i] = in.nextLong();
        }

        System.out.println("Самое длинное число: " + getLongestNumber(array));
        System.out.println("Самое короткое число: " + getShortestNumber(array));
        System.out.println("Числа в порядке возрастания их длинны: " + arrayToString(sortByLength(array)));
        System.out.println("Средня длина числа: " + getAverageLength(array));
        System.out.println("Числа длинна которых меньше средней длины: " + arrayToString(getItemsShorterThenAverage(array)));
        System.out.println("Число, в котором количество различных цифр минмиально: " + getNumberWithMinimalVariousDigits(array));
    }
}
