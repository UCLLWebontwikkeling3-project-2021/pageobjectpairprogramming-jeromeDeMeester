import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class LoginTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }


    public void loginAsUser() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserId("jan");
        loginPage.setPassword("t");
        loginPage.submitValid();
    }
    public void loginAsAdmin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserId("admin");
        loginPage.setPassword("t");
        loginPage.submitValid();
    }
}
