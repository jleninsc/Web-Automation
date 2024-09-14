package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EggHome extends Driver{
    
    public EggHome(WebDriver driver, String url){
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Iniciar sesión")
    private WebElement btnIniciarSesion;

    public void getBtnIniciarSesion() {
        this.btnIniciarSesion.click();
    }
}
