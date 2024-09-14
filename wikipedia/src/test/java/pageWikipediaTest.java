import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WikipediaPage;

public class pageWikipediaTest {
    private WikipediaPage wiki;
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
        wiki = new WikipediaPage(driver, "https://wikipedia.org/");
    }

    @Test
    public void testTitle() {
        Assertions.assertEquals("Wikipedia", wiki.getTitle());
    }

    @Test
    public void testSearch() {
        Assertions.assertEquals("Ingenieria de Software", wiki.getInputValue());
    }

    @Test
    public void testClassBtnPlayStore(){
        Assertions.assertNotEquals("app-badge", wiki.getClassBtnPlayStore());
    }

    @AfterEach
    public void finalizar() {
        wiki.quit();
    }

}
