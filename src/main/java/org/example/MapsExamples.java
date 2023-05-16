package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapsExamples extends BrowserSetup {

    public static void main(String[] args) {
        Map<String, String> objects = new LinkedHashMap<>();
        objects.put("casa", "casa");
        objects.put("copac", "casa");
        objects.put("capac", "colac");

        for (Map.Entry<String, String> e : objects.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());

            System.out.println(e.getValue().equals(e.getKey()));
        }

        System.out.println(objects);
    }
}