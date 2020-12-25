package com.github.artiombond.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTree {
    static int treeDepth = 1;
    static ArrayList<String> treeOfDirectories = new ArrayList();

    public static ArrayList<String> getTreeOfDirectoriesToArrayList(File directory){
        File[] files = directory.listFiles();
        Arrays.sort(files, Comparator.comparing(File::isDirectory));
        for (File file:files){
            String line = "";
            if (file.isFile()){
                for (int i = 0; i < treeDepth *5; i++) {
                    line += " ";
                }
                line += file.getName();
                treeOfDirectories.add(line);
            }else {
                for (int i = 0; i < treeDepth *5 - 2; i++) {
                    line += " ";
                }
                line += "--" + file.getName();
                treeOfDirectories.add(line);
                treeDepth++;
                getTreeOfDirectoriesToArrayList(file);
                treeDepth--;
                for (int i = treeOfDirectories.indexOf(line); i >= 0; i--){
                    if (treeOfDirectories.get(i).charAt(treeDepth *5 - 3) == ' '){
                        String replaсe = treeOfDirectories.get(i).substring(0, treeDepth *5 - 3) + "|" + treeOfDirectories.get(i).substring(treeDepth *5 - 2);
                        treeOfDirectories.set(i, replaсe );
                    }else {
                        break;
                    }
                }
            }
        }
        return treeOfDirectories;
    }

    public static int getCountOfDirectories(ArrayList<String> lines){
        return (int) lines.stream().filter(line -> line.contains("|-")).count();
    }

    public static int getCountOfFiles(ArrayList<String> lines){
        return (int) lines.stream().filter(line -> !line.contains("|-")).count();
    }

    public static double getAverageFileLength(ArrayList<String> lines){
        return lines.stream().filter(line -> !line.contains("|-")).mapToInt((line) -> line.replaceAll("^(\\|*\\s*)*", "").length()).average().getAsDouble();
    }

    public static double getAverageCountOfFilesInDirectories(ArrayList<String> lines){
        return getCountOfFiles(lines)/getCountOfDirectories(lines);
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
                ArrayList lines = new ArrayList();
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    lines.add(line);
                }
                System.out.println(getCountOfDirectories(lines));
                System.out.println(getCountOfFiles(lines));
                System.out.println(getAverageFileLength(lines));
                System.out.println(getAverageCountOfFilesInDirectories(lines));

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
