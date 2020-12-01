import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class PersonOverviewPage extends Page {

    public PersonOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=Overview");
    }

    public boolean containsEmail(String email) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(email)) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsUserId(String userid) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(userid)) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsFirstName(String firstName) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(firstName)) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsLastName(String userid) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(userid)) {
                found=true;
            }
        }
        return found;
    }



    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }


}