package com.lamasurfer.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private final List<String> events = new ArrayList<>();


    public void getEvent(boolean success, File file) {
        String event;
        if (success) {
            if (file.isFile()) {
                event = String.format("Файл %s успешно создан", file.getName());
            } else {
                event = String.format("Папка %s успешно создана", file.getName());
            }
        } else {
            event = String.format("Ошибка при создании файла/папки %s!", file.getName());
        }
        events.add(event);
    }

    public void writeEvents(File tempFile) {

        try (FileWriter fileWriter = new FileWriter(tempFile, true)) {
            for (String event : events) {
                fileWriter.write(event);
                fileWriter.append(";\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка при записи события!");
        }
    }

}
