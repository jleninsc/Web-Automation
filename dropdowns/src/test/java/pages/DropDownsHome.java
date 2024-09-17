package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownsHome extends Driver {

    private WebDriverWait wait;

    public DropDownsHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(id = "dropdownMenuButton")
    private WebElement dropdown;

    public void clicToDropDown() {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        this.dropdown.click();
    }

    @FindBy(css = "#dropdownMenuButton + .dropdown-menu.show a.dropdown-item")
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
