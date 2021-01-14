package com.akbar.employees.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class Files {

    @Value("${filesPath}")
    private static String filePath = "c:\\javod\\employee-api/";

    public static void write(String filename, Object object) {
        try {
            String text = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println("File write, to: " + filePath + filename);

            File file = new File(filePath + filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + filename);
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(text.getBytes(StandardCharsets.UTF_8));
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(String filename) {
        StringBuilder text = new StringBuilder();
        try {
            System.out.println("File read, from: " + filePath + filename);

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath + filename));
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static String readDocs(String filename) {
        StringBuilder text = new StringBuilder();
        try {
            File file = new ClassPathResource("files/" + filename).getFile();
            System.out.println("File read, from: " + file.getName());

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
