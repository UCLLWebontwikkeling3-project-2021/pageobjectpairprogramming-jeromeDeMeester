import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PersonOverviewTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get(path+"?command=Overview");
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



    @Test
    public void test_Overview_NotLoggedIn_ShowsError() {
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You are not allowed to view this page"));
    }

    @Test void test_Overview_LoggedInAsUser_ShowsError() {
        loginAsUser();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You are not allowed to view this page"));
    }

    @Test
    public void test_Register_AllFieldsFilledInCorrectly_UserIsRegistered() {
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        personOverviewPage.containsUserWithEmail("Jan");
        personOverviewPage.containsUserWithUserId("jan");
    }

}
