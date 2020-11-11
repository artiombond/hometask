package com.github.artiombond.collectionstask.optionaltask;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class DifferentWorlds {

    public static void main(String[] args) throws Exception {
        HashSet<String> words = new HashSet<>();
        String file = "src/main/java/com/epam/learning/javaCollections/optionalTask/text.txt";
        Scanner scanner = new Scanner(new File(file));
        while(scanner.hasNextLine()){
            Stream.of(scanner.nextLine().split("[^a-zA-Z&&[^']]")).map(String::toLowerCase)
                    .forEach((s) -> words.add(s));
        }
        System.out.println(words);
    }
}