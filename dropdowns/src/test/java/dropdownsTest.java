import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.DropDownsHome;

public class dropdownsTest {

    private DropDownsHome home;
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
        home = new DropDownsHome(driver, "https://getbootstrap.com/docs/4.3/components/dropdowns/");
        home.maximize();
    }

    @Test
    public void dropdownTest() {
        home.clicToDropDown();
        Assertions.assertTrue(home.isOptionPresent("Action"));
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }
}
