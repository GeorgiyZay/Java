package com.zaitsevGeorgii.task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileFactory extends ObjectFactory<FileWriter> {

    private String fileDirectoty;
    public AtomicInteger currentId = new AtomicInteger(0);

    public FileFactory( String path){
        fileDirectoty = path;
    }

    @Override
    public FileWriter create(){
        File currentDirectory = new File(fileDirectoty);
        if (!currentDirectory.exists()){
            currentDirectory.mkdirs();
        }
        File file = new File(currentDirectory + File.separator + currentId.getAndIncrement() + ".txt");
        try {
            return new FileWriter(file);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
