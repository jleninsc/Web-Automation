package com.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import java.awt.Toolkit;

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

            driver.manage().window().maximize();
            Thread.sleep(3000);

            driver.navigate().to("https://openai.com/");
            Thread.sleep(3000);

            Dimension halfSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
            driver.manage().window().setSize(halfSize);
            Thread.sleep(3000);

            Point center = new Point((Toolkit.getDefaultToolkit().getScreenSize().width - halfSize.width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - halfSize.height) / 2);
            driver.manage().window().setPosition(center);
            Thread.sleep(3000);

            driver.navigate().to("https://www.wikipedia.org/");
            Thread.sleep(3000);

            driver.manage().window().maximize();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}