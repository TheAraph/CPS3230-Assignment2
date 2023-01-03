package org.logintests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Main {

    static WebDriver driver;

    private boolean ValidLogin = false, AlertPage = false, LoginPage = false, LogOut = false;
    public boolean validLoginTest() throws InterruptedException {
        driver = new SafariDriver();
        //get marketalert malta website
        driver.get("https://www.marketalertum.com");

        String userId = ("3e0dc9fb-291e-438e-9fbb-00cc6865af94");

        //find login page button
        String XPathToLoginPage = "/html/body/header/nav/div/div/ul/li[3]/a";
        WebElement LoggingPage = driver.findElement(By.xpath(XPathToLoginPage));
        //click
        LoggingPage.click();

        //wait
        Thread.sleep(5000);

        //find userid field
        WebElement userIDField = driver.findElement(By.id("UserId"));
        //type in userId
        userIDField.sendKeys(userId);
        //submit
        userIDField.submit();

        ValidLogin = true;

        boolean current;

        // wait
        Thread.sleep(5000);
        //making sure that we are on alerts page
        String alertpagemessage = driver.findElement(By.tagName("h1")).getText();
        current = driver.findElements(By.xpath("/html/body/div/main/h1")).size() > 0;
        if (alertpagemessage == "Latest alerts for Adam Ryan Ali Farag") {
            AlertPage = true;
            LoginPage = false;
            LogOut = false;
        }
        return current;
    }

    public boolean isValidLogin() {
        return ValidLogin && AlertPage;
    }

    public boolean isLoggedOut(){
        return LoginPage && LogOut;
    }

    public boolean isLoginPage() {
        if (!ValidLogin){
            ValidLogin = false;

            driver.get("https://www.marketalertum.com/Alerts/Login");

            boolean current;
            current = driver.findElements(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).size() > 0;

            AlertPage = false;
            LoginPage = true;
            LogOut = true;
            ValidLogin = false;
            return current;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public boolean isAlertPage() {
        if (!ValidLogin){
            ValidLogin = false;

            boolean current;
            current = driver.findElements(By.xpath("/html/body/div/main/h1")).size() > 0;

            AlertPage = true;
            LoginPage = false;
            LogOut = false;
            ValidLogin = true;
            return current;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public boolean manualLogOutTest() throws InterruptedException {
        driver = new SafariDriver();
        //get marketalert malta website
        driver.get("https://www.marketalertum.com");

        String userId = ("3e0dc9fb-291e-438e-9fbb-00cc6865af94");

        //find login page button
        String XPathToLoginPage = "/html/body/header/nav/div/div/ul/li[3]/a";
        WebElement LoggingPage = driver.findElement(By.xpath(XPathToLoginPage));
        //click
        LoggingPage.click();

        //wait
        Thread.sleep(5000);

        //find userid field
        WebElement userIDField = driver.findElement(By.id("UserId"));
        //type in userId
        userIDField.sendKeys(userId);
        //submit
        userIDField.submit();

        ValidLogin = true;

        boolean current;

        // wait
        Thread.sleep(5000);
        //making sure that we are on alerts page
        String XPathToLogout = "/html/body/header/nav/div/div/ul/li[3]/a";
        current = driver.findElements(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).size() > 0;
        WebElement LoggingOut = driver.findElement(By.xpath(XPathToLogout));
        LoggingOut.click();

        ValidLogin = false;
        LoginPage = true;
        LogOut = true;

        return current;
    }

    public boolean invalidLoginTest() throws InterruptedException {
        driver = new SafariDriver();
        //get marketalert malta website
        driver.get("https://www.marketalertum.com");

        String userId = ("12345");

        //find login page button
        String XPathToLoginPage = "/html/body/header/nav/div/div/ul/li[3]/a";
        WebElement LoggingPage = driver.findElement(By.xpath(XPathToLoginPage));
        //click
        LoggingPage.click();

        //wait
        Thread.sleep(5000);

        //find userid field
        WebElement userIDField = driver.findElement(By.id("UserId"));
        //type in userId
        userIDField.sendKeys(userId);
        //submit
        userIDField.submit();

        boolean current;

        // wait
        Thread.sleep(5000);
        //making sure that we are on login page
        String name = driver.findElement(By.xpath("/html/body/div/main/form/b")).getText();
        current = driver.findElements(By.id("UserId")).size() > 0;
        if (name == "User ID:") {
            ValidLogin = false;
            AlertPage = false;
            LoginPage = true;
            LogOut = true;
        }
        return current;
    }
}