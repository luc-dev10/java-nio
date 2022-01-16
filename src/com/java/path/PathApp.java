package com.java.path;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PathApp {

    public static void main(String[] args) {

        // // build path
        // Path newPath = Paths.get("src", "com", "java", "current.txt");
        // // readFile(newPath);
        //
        // // get it from project folder
        // Path path = FileSystems.getDefault().getPath("data.txt");
        // // readFile(path);
        //
        // // get it from project folder and travel to another
        // Path travelPath = Paths.get(".", "src", "com", "java", "current.txt");
        // readFile(travelPath);
        //
        // // get the absolute path of current directory
        // Path absolutePathOfApp = Paths.get(".");
        // System.out.println(absolutePathOfApp.toAbsolutePath());

        // copying file
        Path srcFile = FileSystems.getDefault().getPath("data.txt");
        // try {
        //     Files.copy(srcFile, copiedFile);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // moving file
        Path movedPath = FileSystems.getDefault().getPath("copied-dir", "moved2.txt");
        try {
            if (!Files.exists(movedPath))
                Files.move(srcFile, movedPath);

            Files.deleteIfExists(movedPath);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // creating file
    }

    public static void readFile(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            lines.forEach(line -> System.out.println(line));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
