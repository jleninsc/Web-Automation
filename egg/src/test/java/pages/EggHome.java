package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EggHome extends Driver {

    private WebDriverWait wait;

    public EggHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//a[contains(text(),'Iniciar sesión') or contains(text(),'Login')]")
    private WebElement getBtnLogin;

    public void getBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(getBtnLogin));
        this.getBtnLogin.click();
    }

    @FindBy(id = "email")
    private WebElement setInputEmail;

    public void setInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(setInputEmail));
        this.setInputEmail.click();
        this.setInputEmail.sendKeys(email);
        this.setInputEmail.submit();
    }

    @FindBy(id = "password")

    private WebElement setInputPassword;

    public void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(setInputPassword));
        this.setInputPassword.click();
        this.setInputPassword.sendKeys(password);
        // this.setInputPassword.submit();
    }

    @FindBy(css = "button.primary")
    private WebElement setNextBtnLogin;

    public void setNextBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(setNextBtnLogin));
        this.setNextBtnLogin.click();
    }
}
