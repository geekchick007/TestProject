import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.Assert;

import java.net.URL;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Login Fails")
    public static void submitBadLoginForm(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterBadUserName();
        webForm.enterPassword();
        webForm.selectLoginButton();
        Assert.assertTrue(webForm.getErrorMsg().isDisplayed());
    }

    @Test(testName = "Login success")
    public void submitGoodLoginForm(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterUserName();
        webForm.enterPassword();
        webForm.selectLoginButton();
        Assert.assertTrue(webForm.getUserFeed().isDisplayed());
    }

    @Test(testName = "create token")
    public void createToken() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.login();
        wait(2000);
        webForm.selectSettings();
        webForm.selectDevSettings();
        webForm.selectPersonalAccessTokens();
        //enter rest of steps

    }


    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
