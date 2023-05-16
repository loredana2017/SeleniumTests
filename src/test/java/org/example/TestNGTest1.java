package org.example;

import org.example.StartupApp;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTest1 extends StartupApp {

    int a = 5;
    int b = 5;
    int sum = 10;
    String text = "I have two apples.";
    String wordToTest = "apple";

    @Test(description = "Test_11", groups = "smoke-tests")
    public void testSum11() {
        System.out.println("Test_11 sum of: " + a + " and " + b);
        Assert.assertEquals(a+b, sum, "Suma celor 2 nu este corecta.");
    }

    @Test(description = "Test_12", groups = "regression-test")
    public void testText12() {
        System.out.println("Test_12 check if we have word 'apple'.");
        Assert.assertTrue(text.contains(wordToTest), String.format("The given text doesn't contain %s", wordToTest));
    }

}