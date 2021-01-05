package com.ZaitsevGeorgii.Task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class TraversingSubTree {
    private File startDirectory;
    private File resultFile;

    public TraversingSubTree(String directoryPath, String filePath) {
        try {
            File directory = new File(directoryPath).getCanonicalFile();
            File file = new File(filePath).getCanonicalFile();
            if (directory.exists() && directory.isDirectory()) {
                this.startDirectory = directory;
            } else {
                throw new RuntimeException("Папка по указаному путю не существует или не является папкой");
            }
            if (file.exists() && file.isFile()) {
                this.resultFile = file;
            } else {
                throw new RuntimeException("Файл по указаному путю не существует или не является файлом");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void list() {
        try(FileWriter writerResult = new FileWriter(resultFile)) {
            bypass(startDirectory, writerResult);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void bypass(File currentDirectory, FileWriter writerResult) {
        if (currentDirectory.listFiles().length == 0) {
            try{
                writerResult.write("Папка " + currentDirectory.getName() + " пустая\n");
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } else {
            for (File file : currentDirectory.listFiles()) {
                if (file.isDirectory()) {
                    try{
                        writerResult.write("Папка " + file.getName() + "\n");
                        bypass(file, writerResult);
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                } else {
                    try{
                        writerResult.write(file.getName() + "\n");
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
