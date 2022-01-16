package com.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // downloads -> roots -> home/lucio/Downloads
        final Path FILE_PATH = Paths.get("/home/lucio/Downloads/file.txt");

        // read file
//        readToFileWithNio(FILE_PATH);
//
//        // write to file
//        List<String> writeText = new ArrayList<>();
//        writeText.add("text");
//        writeText.add("hello");
//        writeText.add("there again");
//        writeToFileWithNio(FILE_PATH, writeText);

        // read file
        try {
            
            Path dataPath = FileSystems.getDefault().getPath("./src/com/java/current.txt");
            List<String> lines = Files.readAllLines(dataPath);
            lines.forEach(line -> System.out.println(line));

            // this method takes bytes. So conversion is necessary
            Files.write(dataPath, "\nNew Line added".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // write

    }

    // method to read and display  with text
    private static void readToFileWithNio(Path filePath) {

        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"))) {
            reader.lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // method to write to file with text
    private static void writeToFileWithNio(Path filePath, List<String> textList) {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))) {

            for (String text : textList) {
                bufferedWriter.append(text);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}


