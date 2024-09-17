import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.DuckHome;

public class duckTest {

    private DuckHome home;
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

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver(options);
        home = new DuckHome(driver, "https://duckduckgo.com/");
        home.maximize();
    }

    @Test
    public void SideMenuTest() throws InterruptedException {
        Assertions.assertTrue(home.clicToSideMenu(), "El sidemenu no fue clicado correctamente.");
        Assertions.assertTrue(home.selectOption("Ajustes"), "No se encontró la opción.");
        Assertions.assertTrue(home.clicToDropDown());
        Assertions.assertTrue(home.selectOptionPresent("Español (España)"));
        Assertions.assertEquals("es-ES", home.isLanguage());
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }
}
