package com.github.artiombond.collections.optionaltask;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class DifferentWorlds {

    public static void main(String[] args) throws Exception {
        HashSet<String> words = new HashSet<>();
        String file = "src\\main\\resources\\text.txt";
        Scanner scanner = new Scanner(new File(file));
        while(scanner.hasNextLine()){
            Stream.of(scanner.nextLine().split("[^a-zA-Z&&[^']]")).map(String::toLowerCase)
                    .forEach((s) -> words.add(s));
        }
        System.out.println(words);
    }
}