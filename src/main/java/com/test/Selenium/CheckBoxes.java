package com.test.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CheckBoxes {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@class='rct-checkbox']/*[local-name()='svg']")).click();
        Thread.sleep(3000);

        // get text data stored in string
        String str = driver.findElement(By.xpath("//span[text()='You have selected :']")).getText();
        Thread.sleep(2000);

        //list of web elements stored in list
        List<WebElement> list = driver.findElements(By.xpath("//span[text()='You have selected :']/following-sibling::span"));

        //Expected List
        String str1 = "home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";

        //storing in array
        String[] arr = str1.split(" ");

        //create linkedlist - for array of  expected list storing
        List<String> expectedList = new LinkedList();

        for (int i = 0; i <= arr.length; i++) {
            expectedList.add(arr[i]);

        }
        Collections.sort(expectedList);

        //compare the sizes
        if (list.size() == expectedList.size()) {
            System.out.println("list of sizes are equal");
        }

        for (int i = 0; i <= list.size(); i++) {
            if (expectedList.contains(list.get(i).getText().trim())) {
                System.out.println("Test case PASSED");
            } else {
                System.out.println("Test cases FAILED");
            }

            System.out.println(str);

        }
        driver.quit();

    }
}