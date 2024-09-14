import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actIntegrTest {

    private WebDriver driver;

    @BeforeEach
    public void inicializar() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "../chromedriver-win64/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }
        driver = new ChromeDriver();
    }

    @Test
    public void myTestaTitle() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement elementBusqueda = driver.findElement(By.name("q"));
        elementBusqueda.sendKeys("jleninsc");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnBorrar = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Borrar']")));
        Assertions.assertTrue(btnBorrar.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void myTestbMozillaSocial() throws InterruptedException {
        driver.get("https://www.mozilla.org/es-ES/");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String selector = "section.mzp-c-footer-section ul.mzp-c-footer-links-social:nth-of-type(1)";
        WebElement socialElements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        List<WebElement> listSocial = socialElements.findElements(By.tagName("li"));
        Assertions.assertEquals(6, listSocial.size());
    }

    @Test
    public void myTestcBing() throws InterruptedException {
        driver.get("https://www.bing.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        Assertions.assertTrue(search.isDisplayed());
    }

    @Test
    public void myTestdYahoo() throws InterruptedException {
        driver.get("https://login.yahoo.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement selectedCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='persistent']")));
        
    }

    @AfterEach
    public void finalizar() {
        driver.quit();
    }
}
