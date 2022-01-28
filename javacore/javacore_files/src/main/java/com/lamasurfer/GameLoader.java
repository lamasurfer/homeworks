package com.lamasurfer;

import com.lamasurfer.utils.FileZipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

    private final List<GameProgress> progressesList = new ArrayList<>();
    private final GameFiles gameFiles;

    public GameLoader(GameFiles gameFiles) {
        this.gameFiles = gameFiles;
    }

    public void loadProgress(File file) {
        FileZipper fileZipper = new FileZipper();
        File savesDir = gameFiles.getFile("savegames");

        List<File> unzippedFiles = fileZipper.unzipFile(savesDir, file);

        for (File unzippedSave : unzippedFiles) {
            GameProgress gameProgress = openProgress(unzippedSave);
            progressesList.add(gameProgress);
        }
    }

    public GameProgress openProgress(File file) {
        GameProgress gameProgress = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            gameProgress = (GameProgress) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Непредвиденная ошибка при загрузке прогресса игры!");
        }
        return gameProgress;
    }

    public List<GameProgress> getProgressesList() {
        return progressesList;
    }
}
