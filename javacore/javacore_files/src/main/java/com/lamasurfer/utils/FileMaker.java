package com.lamasurfer.utils;

import java.io.File;
import java.io.IOException;

public class FileMaker {

    public boolean make(File file) {
        try {
            if (file.getName().contains(".")) {
                return file.createNewFile();
            } else {
                return file.mkdir();
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл " + file.getName() + "!");
            return false;
        }
    }
}
