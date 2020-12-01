import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */


public class PersonOverviewTest {
    private WebDriver driver;
    private LoginTest loginTest = new LoginTest();
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

    @Test
    public void test_Overview_NotLoggedIn_ShowsError() {
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You are not allowed to view this page"));
    }

    @Test void test_Overview_LoggedInAsUser_ShowsError() {
        loginTest.loginAsUser();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You are not allowed to view this page"));
    }

    @Test
    public void test_Overview_loggedInAsAdmin_ShowsOverview() {
        loginTest.loginAsAdmin();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertTrue(personOverviewPage.containsEmail("jan@mail.com"));
        assertTrue(personOverviewPage.containsUserId("jan"));
        assertTrue(personOverviewPage.containsLastName("Jan"));
        assertTrue(personOverviewPage.containsLastName("Jannsens"));
    }

}
