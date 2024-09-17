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

    public void goToiFrame() {
        driver.switchTo().frame(goToiFrame);
    }

    @FindBy(xpath = "//button[text()='Try it']")
    private WebElement btnTryIt;

    public void clicTryIt() {
        wait.until(ExpectedConditions.elementToBeClickable(btnTryIt));
        this.btnTryIt.click();
    }

    public void sendToAlert(String name) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(name);
        alert.accept();
    }

    public void returnToMain() {
        driver.switchTo().defaultContent();
    }

}
