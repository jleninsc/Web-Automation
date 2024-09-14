import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.EggHome;

public class eggTest {
    private EggHome home;
    private WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "../chromedriver-win64/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/lenin/Documents/Web-Automation/chromedriver-mac-x64/chromedriver");
        }
        driver = new ChromeDriver();
        home = new EggHome(driver, "https://egg.live/es/home");
    }

    @Test
    public void testTitle() {
        Assertions.assertEquals("Egg", home.getTitle());
    }

    @Test
    public void testLogin() throws InterruptedException {
        Thread.sleep(3000);
        home.getBtnIniciarSesion();
        Thread.sleep(30000);
    }

    @AfterEach
    public void finalizar() {
        home.quit();
    }
}
