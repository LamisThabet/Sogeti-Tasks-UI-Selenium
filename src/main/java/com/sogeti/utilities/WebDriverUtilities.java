package com.sogeti.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
    final static int timeOutInSeconds = 60;
    public static void waitUntilElementIsClickable(By by, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        wait.withMessage("Element '" + by + "' was not clickable within defined timeout of " + timeOutInSeconds + " seconds.")
                .until(ExpectedConditions.elementToBeClickable(by));

    }
    public static void checkCorrectPage(String url, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        //if(urlContains(url))
        wait.until(ExpectedConditions.urlContains(url));

    }

    public static boolean checkElementIsSelected(By by, WebDriver driver){
        String attr = driver.findElement(by).getAttribute("class");
        System.out.println("Class text is: "+attr);
        if(attr.contains("selected"))
        {
            System.out.println("WebElement selected");
            return true;}
        else
            System.out.println("WebElement NOT selected");
        return false;
    }

    public static boolean checkExpectedtextisVisible(By by, WebDriver driver,String Expected_text){
        String attr = driver.findElement(by).getText().toLowerCase();
        System.out.println("Actual text is: "+attr);
        if(attr.contains(Expected_text))
        {
            System.out.println("text is visible");
            return true;}
        else
            System.out.println("text not visible");
        return false;
    }

    public static String randomText(){
    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

    System.out.println("generatedString: "+ generatedString);
    return  generatedString;}

    public static String randomNumber(){
        int length = 10;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        //int phone=Integer.parseInt(generatedString);
        //System.out.println("phone: "+ phone);
        return  generatedString;}

    public static String randomEmail(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        String generatedmail=generatedString+"@random.com";
        System.out.println("generatedmail: "+generatedmail);
        return generatedmail;}


}
