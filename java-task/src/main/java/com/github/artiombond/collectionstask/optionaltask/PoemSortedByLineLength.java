package com.github.artiombond.collectionstask.optionaltask;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PoemSortedByLineLength {

    static List<String> poem = Arrays.asList(
            "- В чем смысл твоей жизни? - Меня спросили",
            "Где видишь ты счастье свое, скажи?",
            "- В сраженьях, - ответил я, - против гнили",
            "И в схватках, - добавил я, - против лжи!");

    public static void main(String[] args) {
        Collections.sort(poem,(o1, o2) -> o1.length() - o2.length());
        for (String line: poem) {
            System.out.println(line);
        }
    }
}

