package com.personalizables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main1 {
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
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement cuadroBusqueda = driver.findElement(By.cssSelector("textarea[name='q']"));
            cuadroBusqueda.click();
            cuadroBusqueda.sendKeys("hello world");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}