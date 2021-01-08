package com.zaitsev.task4;

import com.zaitsevGeorgii.task4.TraversingSubTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TraversingTest {

    @Test
    void testIncorrectPathToDirectory(){
        String pathToDir = "./directoryForTask2342434";
        String pathToResult = "./resultTask4/result.txt";
        Assertions.assertThrows(RuntimeException.class, () -> new TraversingSubTree(pathToDir, pathToResult));
    }

    @Test
    void testIncorrectPathToFile(){
        String pathToDir = "./directoryForTask4";
        String pathToResult = "./result/result.txt";
        Assertions.assertThrows(RuntimeException.class, () -> new TraversingSubTree(pathToDir, pathToResult));
    }

    @Test
    void testNotDirectory(){
        String pathToDir = "./resultTask4/result.txt";
        String pathToResult = "./resultTask4/result.txt";
        Assertions.assertThrows(RuntimeException.class, () -> new TraversingSubTree(pathToDir, pathToResult));
    }

    @Test
    void testNotFileForWrite(){
        String pathToDir = "./directoryForTask4";
        String pathToResult = "./directoryForTask4";
        Assertions.assertThrows(RuntimeException.class, () -> new TraversingSubTree(pathToDir, pathToResult));
    }

    @Test
    void testEmptyDirectory(){
        String pathToDir = "./directoryForTask4/emptyDir";
        String pathToResult = "./resultTask4/result.txt";
        String resultString = "Папка emptyDir пустая";
        String result = new String();

        TraversingSubTree exampe = new TraversingSubTree(pathToDir, pathToResult);
        exampe.list();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToResult))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals(result, resultString);
    }

    @Test
    void testCorrect(){
        String pathToDir = "./directoryForTask4";
        String pathToResult = "./resultTask4/result.txt";
        String resultString = "Папка emptyDir\n" +
                "Папка emptyDir пустая\n" +
                "Папка image\n" +
                "LogIn.png\n" +
                "Project.png\n" +
                "Registr.png\n" +
                "View.png\n" +
                "Диаграмма.jpg\n" +
                "Папка someFile\n" +
                "interestingfact\n" +
                "something\n";
        String result = new String();

        TraversingSubTree exampe = new TraversingSubTree(pathToDir, pathToResult);
        exampe.list();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToResult))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals(result, resultString);
    }
}
