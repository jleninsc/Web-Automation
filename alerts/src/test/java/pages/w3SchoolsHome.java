package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class w3SchoolsHome extends Driver {

    private WebDriverWait wait;

    public w3SchoolsHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(css = "iframe#iframeResult")
    private WebElement goToiFrame;

    public boolean goToiFrame() {
        try {
            driver.switchTo().frame(goToiFrame);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//button[text()='Try it']")
    private WebElement btnTryIt;

    public boolean clicTryIt() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnTryIt));
            this.btnTryIt.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendToAlert(String name) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.sendKeys(name);
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void returnToMain() {
        driver.switchTo().defaultContent();
    }

}
