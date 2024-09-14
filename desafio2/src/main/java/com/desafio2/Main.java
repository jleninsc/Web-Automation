package com.desafio2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://accounts.google.com/");
            Thread.sleep(3000);

            WebElement inputEmail = driver.findElement(By.name("identifier"));
            inputEmail.sendKeys("testssistemas@gmail.com");
            inputEmail.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            WebElement inputPasswd = driver.findElement(By.name("Passwd"));
            inputPasswd.sendKeys("-----");
            inputPasswd.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }

    }
}
