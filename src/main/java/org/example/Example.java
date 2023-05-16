package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidArgumentException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Example {

    public static void main(String[] args) {

        File newFile = new File("D:\\SkillBrain\\homework\\selenium-java2\\src\\main\\java\\org\\example\\text.txt");
        File fileClass = new File("D:\\SkillBrain\\homework\\selenium-java2\\src\\main\\java\\org\\example\\MainAlerts.java");

        int result = copyFileTo(fileClass, newFile);
        System.out.println(result);
    }

    private static int copyFileTo(File input, File output) {
        System.out.println("Copying " + input.getName() + " to " + output.getName() + ".");

        try {
            FileUtils.copyFile(input, output);
            return 0;
        } catch (IOException ioe) {
            System.out.println("ERROR: Make sure the path is correct to your file: " + ioe.getMessage());
            return 1;
            //throw new IllegalArgumentException(ioe.getMessage());
        } finally {
            System.out.println("Finally block.");
        }

        //System.out.println("Cool, you just copied the file!");
    }
}