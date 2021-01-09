package com.zaitsev.task5;

import com.zaitsevGeorgii.task5.EquationClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EquationClassTest {
    @Test
    public void testCountOfFile(){
        String pathDirectory = "./fortask5";
        EquationClass.main(null);
        File directory = new File(pathDirectory);
        Assertions.assertEquals(4, directory.listFiles().length);
    }

    @Test
    public void testCountOfString(){
        String pathDirectory = "./fortask5";
        EquationClass.main(null);
        File directory = new File(pathDirectory);
        for(File out: directory.listFiles()){
            try{
                Assertions.assertEquals(2500, Files.lines(out.toPath()).count());
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
