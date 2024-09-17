package pages;

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

    public void maximize(){
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    public void deleteAllCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

}