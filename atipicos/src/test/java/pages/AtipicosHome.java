package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AtipicosHome extends Driver {

    private WebDriverWait wait;

    public AtipicosHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(css = "iframe#iframeResult")
    private WebElement goToiframeResult;

    public boolean goToiframeResult() {
        try {
            driver.switchTo().frame(goToiframeResult);
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

    public boolean acceptToAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void returnToMain() {
        driver.switchTo().defaultContent();
    }

    @FindBy(id = "tryhome")
    WebElement btnHome;

    public boolean clicToHome() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnHome));
            this.btnHome.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[contains(@class, 'ga-nav') and contains(@class, 'subtopnav_firstitem')]")
    WebElement btnHtmlCourse;

    public boolean clicToHtml() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnHtmlCourse));
            this.btnHtmlCourse.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[text()='HTML Tag List']")
    WebElement btnHtmlTagList;

    public boolean clicToHtmlTagList() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnHtmlTagList));
            this.btnHtmlTagList.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[contains(@class, 'no-checkmark')   and contains(@href,'tag_select.asp')]")
    WebElement btnHtmlSelectTag;

    public boolean clicToHtmlSelectTag() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnHtmlSelectTag));
            this.btnHtmlSelectTag.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[contains(@href,'tryit.asp?filename=tryhtml_select')]")
    WebElement btnTryitYourself;

    public boolean clicToTryitYourself() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnTryitYourself));
            this.btnTryitYourself.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(id = "cars")
    WebElement dropdownCars;

    public boolean clicToDropdownCars() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dropdownCars));
            this.dropdownCars.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(css = "#cars option")
    private List<WebElement> dropdownOptions;

    public boolean isOptionPresent(String searchOption) {
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals(searchOption)) {
                return true;
            }
        }
        return false;
    }

}
