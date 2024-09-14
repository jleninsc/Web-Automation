package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends Driver {

    public GoogleHomePage(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "APjFqb")
    private WebElement input;

    public String getInputValue() {
        return this.input.getAttribute("value");
    }
}
