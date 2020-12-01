import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class LoginPage extends Page {

    @FindBy(id="userId")
    private WebElement userIdField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="loginIn")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void setUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public HomePage submitValid() {
        logInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

}
