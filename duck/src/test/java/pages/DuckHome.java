package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuckHome extends Driver {

    private WebDriverWait wait;

    public DuckHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "(//button[@data-testid='sidemenu-button'])[2]")
    private WebElement sidemenu;

    public boolean clicToSideMenu() {
        try {
            wait.until(ExpectedConditions.visibilityOf(sidemenu));
            this.sidemenu.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "(//div[contains(@class, 'sideMenu_sideMenuContent__OE7n9')])[2] //a[@class='sideMenu_sectionLink__Ig1Qo']")
    private List<WebElement> listOptions;

    public boolean selectOption(String searchOption) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(listOptions));
            for (WebElement option : listOptions) {
                System.out.println("Option: " + option.getText());
                if (option.getText().equalsIgnoreCase(searchOption)) {
                    option.click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(id = "setting_kad")
    private WebElement dropdown;

    public boolean clicToDropDown() {
        try {
            wait.until(ExpectedConditions.visibilityOf(dropdown));
            this.dropdown.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//select[@id='setting_kad']//option")
    private List<WebElement> dropdownOptions;

    public boolean selectOptionPresent(String searchOption) {
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals(searchOption)) {
                option.click();
                return true;
            }
        }
        return false;
    }

    @FindBy(tagName = "html")
    private WebElement lang;

    public String isLanguage() {
        return lang.getAttribute("lang");
    }

}
