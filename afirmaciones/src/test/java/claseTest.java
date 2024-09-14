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

public class claseTest {

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
        String titulo = driver.getTitle();
        Assertions.assertEquals("Google", titulo);
    }

    @Test
    public void myTestbLogo() throws InterruptedException{
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        WebElement elementLogo = driver.findElement(By.cssSelector("img[class='lnXdpd']"));
        String classLogo = elementLogo.getAttribute("class");
        Assertions.assertNotEquals("logo-class", classLogo);
    }

    @Test
    public void myTestcHotmail() throws InterruptedException{
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement elementBusqueda = driver.findElement(By.name("q"));
        elementBusqueda.sendKeys("hotmail");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox'] li")));
        List<WebElement> myList = driver.findElements(By.cssSelector("ul[role='listbox'] li"));
        WebElement firstElement = myList.get(0);
        String element = firstElement.getText();
        Assertions.assertEquals("hotmail", element);
    }

    @Test
    public void myTestdLogin()throws InterruptedException{
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        WebElement btnAcceder = driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión') or contains(text(),'Acceder')]"));
        String classBtnAcceder = btnAcceder.getAttribute("class");
        Assertions.assertFalse(classBtnAcceder.equals("btn-login"));
    }

    @AfterEach
    public void finalizar(){
        driver.quit();
    }

}
