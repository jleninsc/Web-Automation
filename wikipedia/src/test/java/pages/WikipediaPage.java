package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage extends Driver{
    
    public WikipediaPage(WebDriver driver, String url){
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchInput")
    private WebElement input;

    public String getInputValue() {
        this.input.sendKeys("Ingenieria de Software");
        return this.input.getAttribute("value");
    }

    @FindBy(css = "div.footer-sidebar-text ul li:nth-of-type(1)")
    private WebElement btnPlayStore;

    public String getClassBtnPlayStore(){
        return this.btnPlayStore.getAttribute("class");
    }
}
