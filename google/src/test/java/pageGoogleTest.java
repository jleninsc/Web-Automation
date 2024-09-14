import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleHomePage;

public class pageGoogleTest {

    private GoogleHomePage home;
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
        home = new GoogleHomePage(driver, "https://www.google.com");
    }

    @Test
    public void testTitle() {
        Assertions.assertEquals("Google", home.getTitle());
    }

    @Test
    public void testSearch() {
        Assertions.assertEquals("", home.getInputValue());
    }

    @AfterEach
    public void finalizar() {
        driver.quit();
    }
}
