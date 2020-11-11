package com.github.artiombond.collectionstask.optionaltask;

import java.util.Scanner;
import java.util.Stack;

public class NumberReverse {

    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число\n");
        int number = input.nextInt();
        while(number != 0){
            numberStack.push(number%10);
            number = number/10;
        }
        int reverseNumber = 0;
        int i = 0;
        while(!numberStack.empty()){
            reverseNumber += Math.pow(10,i)*numberStack.pop();
            i += 1;
        }
        System.out.println(reverseNumber);
    }
}
