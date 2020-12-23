package com.github.artiombond.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileTree {
    static int levelOfTree = 1;
    static ArrayList<String> treeOfDirectories = new ArrayList();

    public static ArrayList<String> getTreeOfDirectoriesToArrayList(File directory){
        File[] files = directory.listFiles();
        Arrays.sort(files, Comparator.comparing(File::isDirectory));
        for (File file:files){
            String line = "";
            if (file.isFile()){
                for (int i = 0; i < levelOfTree*5; i++) {
                    line += " ";
                }
                line += file.getName();
                treeOfDirectories.add(line);
            }else {
                for (int i = 0; i < levelOfTree*5 - 2; i++) {
                    line += " ";
                }
                line += "--" + file.getName();
                treeOfDirectories.add(line);
                levelOfTree++;
                getTreeOfDirectoriesToArrayList(file);
                levelOfTree--;
                for (int i = treeOfDirectories.indexOf(line); i >= 0; i--){
                    if (treeOfDirectories.get(i).charAt(levelOfTree*5 - 3) == ' '){
                        String replaсe = treeOfDirectories.get(i).substring(0,levelOfTree*5 - 3) + "|" + treeOfDirectories.get(i).substring(levelOfTree*5 - 2);
                        treeOfDirectories.set(i, replaсe );
                    }else {
                        break;
                    }
                }
            }
        }
        return treeOfDirectories;
    }

    public static int getCountOfDirectories(File directory ){
        int countOfDirectories = 0;
        File[] files = directory.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                countOfDirectories += 1 + getCountOfDirectories(file);
            }
        }
        return countOfDirectories;
    }

    public static int getCountOfFiles(File directory){
        int countFiles = 0;
        File[] files = directory.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                countFiles += getCountOfFiles(file);
            }else {
                countFiles++;
            }
        }
        return countFiles;
    }

    public static float getFileNamesLength(File directory){
        int lengthOfFileNames = 0;
        File[] files = directory.listFiles();
        for (File file:files){
            if (file.isDirectory()){
                lengthOfFileNames += getFileNamesLength(file);
            }else {
                lengthOfFileNames += file.getName().length();
            }
        }
        return lengthOfFileNames;
    }


    public static void main(String[] args) {

        File fileInput = new File(args[0]);

        if (fileInput.isDirectory() && fileInput.exists()){
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/tree.txt"))) {
                for (String line:getTreeOfDirectoriesToArrayList(fileInput)){
                    bufferedWriter.write(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(fileInput.exists()){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInput))){
                String directoryPath = bufferedReader.readLine();
                File directory = new File(directoryPath);
                System.out.println("Count of directories: " + getCountOfDirectories(directory));
                System.out.println("Count of files: " + getCountOfFiles(directory));
                System.out.println("Average count of files in directory: " + (float) getCountOfFiles(directory)/getCountOfDirectories(directory));
                System.out.println("Average file name length: " + getFileNamesLength(directory)/getCountOfFiles(directory));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
