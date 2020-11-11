package com.github.artiombond.collectionstask.optionaltask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LinesFromFileSort {

    public static void main(String[] args) throws Exception {

        List<String> textFromFile = new ArrayList<>();
        String file = "src\\main\\java\\com\\github\\artiombond\\collectionstask\\optionaltask\\text.txt";
        Scanner scanner = new Scanner(new File(file));
        while(scanner.hasNextLine()){
            textFromFile.add(scanner.nextLine());
        }
        Collections.sort(textFromFile);
        for (String line:
                textFromFile) {
            System.out.println(line);
        }
    }

}
