package com.localizadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            driver.manage().window().maximize();
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(3000);

            WebElement search = driver.findElement(By.id("searchInput"));
            search.sendKeys("Ingeniería de Software");
            Thread.sleep(3000);

            driver.navigate().to("https://github.com/");
            WebElement inputEmail = driver.findElement(By.name("user_email"));
            inputEmail.sendKeys("sclenins@gmail.com");
            Thread.sleep(3000);

            WebElement btnLogin = driver.findElement(By.partialLinkText("Sign in"));
            btnLogin.click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        
    }
}