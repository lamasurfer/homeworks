package com.lamasurfer;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        final String WIN_HDD = "D:";
//        GameFiles gameFiles = new GameFiles(WIN_HDD);

//        по умолчанию установит в String root = System.getProperty("user.home");
        GameFiles gameFiles = new GameFiles();

        gameFiles.addRootFolder("Games");
        gameFiles.addSubElements("Games", "GunRunner");
        gameFiles.addSubElements("GunRunner", "src", "res", "savegames", "temp");
        gameFiles.addSubElements("src", "main", "test");
        gameFiles.addSubElements("res", "drawables", "vectors", "icons");
        gameFiles.addSubElements("main", "Main.java", "Utils.java");
        gameFiles.addSubElements("temp", "temp.txt");
        gameFiles.install();

        GameProgress gp1 = new GameProgress(100, 5, 3, 500);
        GameProgress gp2 = new GameProgress(75, 4, 4, 1500);
        GameProgress gp3 = new GameProgress(15, 3, 5, 5500);

        GameSaver gameSaver = new GameSaver(gameFiles);

        File zippedSave = gameSaver.saveProgress(gp1, gp2, gp3);

        GameLoader gameLoader = new GameLoader(gameFiles);
        gameLoader.loadProgress(zippedSave);

        List<GameProgress> openedProgressList = gameLoader.getProgressesList();

        for (GameProgress gameProgress : openedProgressList) {
            System.out.println(gameProgress);
        }
    }
}

