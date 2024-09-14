import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
        ChromeOptions options = new ChromeOptions();        
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        
        driver = new ChromeDriver(options);
        home = new EggHome(driver, "https://egg.live/es/home");
    }

    @Test
    public void testaTitle() {
        Assertions.assertEquals("Egg", home.getTitle());
    }

    @Test
    public void testbLogin() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        home.getBtnLogin();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        home.setInputEmail("sclenins@gmail.com");
        home.setInputPassword("sC3l3n1ns");
        home.setNextBtnLogin();
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }
}
