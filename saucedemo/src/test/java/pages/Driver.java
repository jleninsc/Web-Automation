package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public Driver(WebDriver driver, String url) {
        this.driver = driver;
        this.driver.get(url);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void maximize() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    public void deleteAllCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    public void switchToWindows(int numberWindow) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        if (numberWindow <= 0 || numberWindow > windows.size()) {
            throw new IllegalArgumentException("Número de ventana inválido: " + numberWindow);
        }
        driver.switchTo().window(windows.get(numberWindow - 1));
    }

}