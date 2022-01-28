package com.lamasurfer;

import com.lamasurfer.utils.FileZipper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameSaver {


    private static int counter = 0;
    private final GameFiles gameFiles;

    public GameSaver(GameFiles gameFiles) {
        this.gameFiles = gameFiles;
    }

    public File saveProgress(GameProgress... gameProgresses) {
        FileZipper fileZipper = new FileZipper();
        List<File> filesToZip = new ArrayList<>();
        for (GameProgress gameProgress : gameProgresses) {
            File saveFile = saveGame(gameProgress);
            filesToZip.add(saveFile);
        }
        File savesDir = gameFiles.getFile("savegames");
        return fileZipper.zipFile(savesDir, filesToZip);
    }

    public File saveGame(GameProgress gameProgress) {
        final String SAVE_NAME = "save";
        final String SAVE_EXTENSION = ".dat";
        String saveName = SAVE_NAME + (counter++) + SAVE_EXTENSION;
        File savesFolder = gameFiles.getFile("savegames");
        File saveFile = new File(savesFolder, saveName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {

            oos.writeObject(gameProgress);

        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка при записи прогресса игры!");
        }
        return saveFile;
    }
}
