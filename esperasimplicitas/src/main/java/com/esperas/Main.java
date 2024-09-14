package com.esperas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        example();
        // exampleLinkedInLogin(15, "https://www.google.com");
        // exampleGitHub(25, "https://github.com/");
        // exampleWikipedia(5, "https://www.wikipedia.org/");

    }

    public static void example() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement cuadroBusqueda = driver.findElement(By.cssSelector("textarea[name='q']"));
        cuadroBusqueda.click();
        cuadroBusqueda.sendKeys("Egg Corporation");

        WebElement lupaBusqueda = driver.findElement(By.cssSelector("input[name='btnK']"));
        lupaBusqueda.click();

    }

    public static void exampleLinkedInLogin(int time, String url) {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.navigate().to(url);

        WebElement botonLogin = driver.findElement(By.cssSelector("button[aria-label='Iniciar sesión']"));
        botonLogin.click();

    }

    public static void exampleGitHub(int time, String url) {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.navigate().to(url);

        WebElement inputEmail = driver.findElement(By.cssSelector("input[id='hero_user_email']"));
        inputEmail.click();
        inputEmail.sendKeys("mailPrueba");

    }

    public static void exampleWikipedia(int time, String url) {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver-win64\\chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.navigate().to(url);

        WebElement inputSearch = driver.findElement(By.cssSelector("input[id='searchInput']"));
        inputSearch.click();
        inputSearch.sendKeys("Pruebas de software");

    }
}