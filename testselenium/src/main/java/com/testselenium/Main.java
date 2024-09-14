package com.testselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            Thread.sleep(3000);
            driver.manage().window().minimize();
            driver.navigate().to("https://openai.com/");
            Thread.sleep(4000);
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.navigate().to("https://github.com/");
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
            driver.navigate().forward();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        
    }
}