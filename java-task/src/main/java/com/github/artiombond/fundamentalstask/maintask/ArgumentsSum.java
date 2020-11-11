package com.github.artiombond.fundamentalstask.maintask;

public class ArgumentsSum {
    public static void main( String[] args )
    {
        int sum = 0;
        if (args.length > 0 ){
            for (int i = 0 ; i < args.length; i++){
                sum += Integer.parseInt(args[i]);
            }
            System.out.println(sum);
        }

    }
}
