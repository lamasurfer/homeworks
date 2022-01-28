package com.lamasurfer;

import com.lamasurfer.utils.FileMaker;
import com.lamasurfer.utils.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameFiles {

    private final String root;
    private final List<File> fileList = new ArrayList<>();

    public GameFiles() {
        this.root = System.getProperty("user.home");
    }

    public GameFiles(String root) {
        this.root = root;
    }

    public void addRootFolder(String rootFolderName) {
        if (fileList.isEmpty()) {
            File installDir = new File(root + File.separator + rootFolderName);
            fileList.add(installDir);
        }
    }

    public void addSubElements(String parentName, String... subElements) {
        File key = getFile(parentName);
        if (key == null || subElements.length == 0) return;

        for (String subElement : subElements) {
            File toAdd = new File(key, subElement);
            fileList.add(toAdd);
        }
    }

    public File getFile(String fileName) {
        for (File file : fileList) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public void install() {
        FileMaker fileMaker = new FileMaker();
        Logger logger = new Logger();
        for (File file : fileList) {
            if (file.exists()) continue;
            boolean success = fileMaker.make(file);
            logger.getEvent(success, file);
        }
        File tempFile = getFile("temp.txt");
        logger.writeEvents(tempFile);
    }

    public void showTree() {
        for (File file : fileList) {
            System.out.println(file);
        }
    }

    public void uninstall() {
        fileList.sort(Comparator.reverseOrder());
        for (File file : fileList) {
            file.delete();
        }
    }
}
