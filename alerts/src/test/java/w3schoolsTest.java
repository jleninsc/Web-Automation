import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.w3SchoolsHome;

public class w3schoolsTest {

    private w3SchoolsHome home;
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
        home = new w3SchoolsHome(driver, "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        home.maximize();
    }

    @Test
    public void alertsTest() throws InterruptedException {
        Assertions.assertTrue(home.goToiFrame(), "No se pudo acceder al iframe correctamente.");
        Assertions.assertTrue(home.clicTryIt(), "El botón 'Try it' no fue clicado correctamente.");
        Assertions.assertTrue(home.sendToAlert("Lenin"),
                "El nombre no fue enviado al alert correctamente o el alert no fue aceptado.");
        Thread.sleep(4000);
        home.returnToMain();
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }

}
