import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.AtipicosHome;

public class atipicosTest {

    private AtipicosHome home;
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
        home = new AtipicosHome(driver, "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        home.maximize();
    }

    @Test
    public void atipicos() throws InterruptedException {
        Assertions.assertTrue(home.goToiframeResult(), "No se pudo localizar el iFrame");
        Assertions.assertTrue(home.clicTryIt(), "No se pudo hacer clic en el botón Try it");
        Assertions.assertTrue(home.acceptToAlert(), "No se pudo aceptar la alerta");
        home.returnToMain();
        Assertions.assertTrue(home.clicToHome(), "No se pudo clicar en el botón Home");
        home.switchToWindows(2);
        Assertions.assertTrue(home.clicToHtml(), "No se pudo hacer clic en el botón HTML");
        Assertions.assertTrue(home.clicToHtmlTagList(), "No se pudo hacer clic en el botón Html Tag List");
        Assertions.assertTrue(home.clicToHtmlSelectTag(), "No se pudo hacer clic en el Tag <selec>");
        Assertions.assertTrue(home.clicToTryitYourself(), "No se pudo hacer clic en Try it Yourself");
        home.switchToWindows(3);
        Assertions.assertTrue(home.goToiframeResult(), "No se pudo localizar el iFrame");
        Assertions.assertTrue(home.clicToDropdownCars(), "");
        Assertions.assertTrue(home.isOptionPresent("Volvo"));
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }

}
