import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.SauceDemoHome;

public class sauceDemoTest {

    private SauceDemoHome home;
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
        home = new SauceDemoHome(driver, "https://www.saucedemo.com/v1/index.html");
        // home.maximize();
    }

    @Test
    public void login() throws InterruptedException {
        String user = home.getUsername(1);
        home.setUserName(user);
        String password = home.getUserPassword(1);
        home.setUserPassword(password);
        Assertions.assertTrue(home.clicToLogin());
        Thread.sleep(4000);
    }

    @Test
    public void loginUsernameEmpty() throws InterruptedException {
        home.setUserName("");
        home.setUserPassword("");
        Assertions.assertTrue(home.clicToLogin());
        Assertions.assertEquals("Username is required", home.getDataError());
        Assertions.assertTrue(home.closeError());
        Thread.sleep(4000);
    }

    @Test
    public void loginPasswordEmpty() throws InterruptedException {
        String user = home.getUsername(1);
        home.setUserName(user);
        home.setUserPassword("");
        Assertions.assertTrue(home.clicToLogin());
        Assertions.assertEquals("Password is required", home.getDataError());
        Assertions.assertTrue(home.closeError());
        Thread.sleep(4000);
    }

    @Test
    public void loginAllUsers() throws InterruptedException {
        List<String> users = home.getUsernames();
        List<String> passwords = home.getUserPasswords();
        for (int i = 0; i < users.size(); i++) {
            home.cleanUser();
            home.setUserName(users.get(i));
            home.cleanPassword();
            home.setUserPassword(passwords.get(0));
            Assertions.assertTrue(home.clicToLogin());
            Thread.sleep(4000);
            if (!home.closeError()) {
                Assertions.assertTrue(home.clicToBtnBurger());
                Assertions.assertTrue(home.clicOption("Logout"));
            }
        }
    }

    @AfterEach
    public void tearDown() {
        home.deleteAllCookies();
        home.quit();
    }

}
