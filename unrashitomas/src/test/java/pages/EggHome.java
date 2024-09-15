package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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
        this.setInputPassword.submit();
    }

    @FindBy(css = "button.primary")
    private WebElement setNextBtnLogin;

    public void setNextBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(setNextBtnLogin));
        this.setNextBtnLogin.click();
    }

    @FindBy(css = "article")
    private List<WebElement> articlesCourses;

    public void selectCurso(String course) {
        wait.until(ExpectedConditions.visibilityOfAllElements(articlesCourses));
        for (WebElement article : articlesCourses) {
            WebElement titleCourse = article.findElement(By.cssSelector("div.title"));
            if (titleCourse.getText().toLowerCase().contains(course.toLowerCase())) {
                WebElement contentButton = article.findElement(By.cssSelector("button.primary.white"));
                wait.until(ExpectedConditions.elementToBeClickable(contentButton));
                contentButton.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//div[@style='display: flex; justify-content: space-between; align-items: center; gap: 1ch; margin-bottom: 21px;']")
    private List<WebElement> listRashables;

    public void rashar(String name) {
        wait.until(ExpectedConditions.visibilityOfAllElements(listRashables));
        for (WebElement rashable : listRashables) {
            WebElement rashableElement = rashable.findElement(By.xpath(".//span[@style='flex-grow: 2; font-size: 13px;']"));
            wait.until(ExpectedConditions.visibilityOf(rashableElement));
            System.out.println("User: " + rashableElement.getAttribute("textContent"));
            if (rashableElement.getText().toLowerCase().contains(name)) {
                WebElement btnRasho = rashable.findElement(By.tagName("button"));
                wait.until(ExpectedConditions.elementToBeClickable(btnRasho));
                btnRasho.click();
                break;
            }
        }
    }
}