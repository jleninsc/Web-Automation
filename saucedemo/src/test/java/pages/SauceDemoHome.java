package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoHome extends Driver {

    private WebDriverWait wait;

    public SauceDemoHome(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(id = "login_credentials")
    private WebElement listUsers;

    public String getUsername(int index) {
        String users = listUsers.getText();
        List<String> usernames = Arrays.asList(users.split("\\n"));
        if (index >= 0 && index < usernames.size()) {
            return usernames.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango. El tamaño de la lista es " + usernames.size());
        }
    }

    public List<String> getUsernames() {
        String users = listUsers.getText();
        List<String> usernames = new ArrayList<>(Arrays.asList(users.split("\\n")));
        if (!usernames.isEmpty()) {
            usernames.remove(0);
        }
        return usernames;
    }

    @FindBy(css = "div.login_password")
    private WebElement listUserPasswords;

    public String getUserPassword(int index) {
        String passwords = listUserPasswords.getText();
        List<String> userpasswords = Arrays.asList(passwords.split("\\n"));
        if (index >= 0 && index < userpasswords.size()) {
            return userpasswords.get(index);
        } else {
            throw new IndexOutOfBoundsException(
                    "Índice fuera de rango. El tamaño de la lista es " + userpasswords.size());
        }
    }

    public List<String> getUserPasswords() {
        String passwords = listUserPasswords.getText();
        List<String> userpasswords = new ArrayList<>(Arrays.asList(passwords.split("\\n")));
        if (!userpasswords.isEmpty()) {
            userpasswords.remove(0);
        }
        return userpasswords;
    }

    @FindBy(id = "user-name")
    private WebElement username;

    public void setUserName(String user) {
        wait.until(ExpectedConditions.visibilityOf(username));
        this.username.click();
        this.username.sendKeys(user);
    }

    @FindBy(id = "password")
    private WebElement userpassword;

    public void setUserPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(userpassword));
        this.userpassword.click();
        this.userpassword.sendKeys(password);
    }

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public boolean clicToLogin() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnLogin));
            this.btnLogin.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(css = "h3[data-test = 'error']")
    private WebElement messageErrorData;

    public String getDataError() {
        String messagesError = messageErrorData.getText();
        if (messagesError.length() > 15) {
            return messagesError.substring(14).trim();
        } else {
            throw new IndexOutOfBoundsException("No hubo mensajes de error");
        }
    }

    @FindBy(css = "button[class = 'error-button']")
    private WebElement btnError;

    public boolean closeError() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnError));
            this.btnError.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(css = "div[class = 'bm-burger-button']")
    private WebElement btnBurger;

    public boolean clicToBtnBurger() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnBurger));
            this.btnBurger.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(css = ".bm-item-list a")
    private List<WebElement> sidebarOptions;

    public boolean clicOption(String searchOption) {
        wait.until(ExpectedConditions.visibilityOfAllElements(sidebarOptions));
        for (WebElement option : sidebarOptions) {
            if (option.getText().equals(searchOption)) {
                option.click();
                return true;
            }
        }
        return false;
    }

}
