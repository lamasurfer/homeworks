package com.lamasurfer.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileZipper {

    public File zipFile(File path, List<File> sourceFiles) {
        final String ZIP_NAME = "saves.zip";
        File zipFile = new File(path, ZIP_NAME);
        try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(zipFile));
             ZipOutputStream zout = new ZipOutputStream(bout)) {

            for (File sourceFile : sourceFiles) {
                ZipEntry zipEntry = new ZipEntry(sourceFile.getName());
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));

                zout.putNextEntry(zipEntry);

                byte[] bytes = new byte[2048];
                int length;
                while ((length = bis.read(bytes)) >= 0) {
                    zout.write(bytes, 0, length);
                }
                zout.closeEntry();
                bis.close();
                sourceFile.delete();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return zipFile;
    }

    public List<File> unzipFile(File path, File zipFile) {
        List<File> unzippedFiles = new ArrayList<>();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(zipFile));
             ZipInputStream zis = new ZipInputStream(bis)) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                File outputFile = new File(path, zipEntry.getName());
                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(outputFile));

                byte[] bytes = new byte[2048];
                int length;
                while ((length = zis.read(bytes)) > 0) {
                    bout.write(bytes, 0, length);
                }
                bout.flush();
                bout.close();
                zis.closeEntry();
                unzippedFiles.add(outputFile);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        zipFile.delete();
        return unzippedFiles;
    }
}
