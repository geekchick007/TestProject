import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{

    private final String USERNAME = "geekchick007@gmail.com";
    private final String BADUSERNAME = "PeterRabbit@gmail.com";

    private final String PASSWORD = "secret";

    @FindBy(id = "login_field")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement submit_button;

    @FindBy(xpath = "//a[contains(text(),'incorrect username or password')]")
    private WebElement loginErrorMsg;

    @FindBy(id = "feed-original")
    private WebElement loginSuccess;

    @FindBy(css = ".avatar-small")
    private WebElement userProfile;

    @FindBy(linkText = "Settings")
    private WebElement userSettings;

    @FindBy(linkText = "Generate new token")
    private WebElement genToken;

    @FindBy(partialLinkText = "Developer settings")
    private WebElement devSettings;
    @FindBy(css = "#personal-access-tokens-menu-item>span.ActionListItem-label")
    private WebElement personaAccessTokens;

    @FindBy(id = "oauth_access_description")
    private WebElement tokenName;

    @FindBy(id = "oauth_access_default_expires_at")
    private WebElement tokeexp;

    @FindBy(css = "input[value='workflow']")
    private WebElement workflow;

    @FindBy(css = "input[value='user']")
    private WebElement chooseUser;


    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(){
        this.username.sendKeys(USERNAME);
    }

    public void enterBadUserName(){
        this.username.sendKeys(BADUSERNAME);
    }

    public void enterPassword(){
        this.username.sendKeys(PASSWORD);
    }

    public void selectLoginButton(){
        this.submit_button.click();
    }

    public WebElement getErrorMsg(){
       return this.loginErrorMsg;
    }

    public WebElement getUserFeed(){
        return this.loginSuccess;
    }

    public void login(){
        enterUserName();
        enterPassword();
        selectLoginButton();
    }

    public WebElement selectSettings(){
        return this.userSettings;
    }
    public WebElement selectDevSettings(){
        return this.devSettings;
    }

    public WebElement selectPersonalAccessTokens(){
        return this.personaAccessTokens;
    }

    public WebElement selectCreatClassicToken(){
        return this.genToken;
    }

    public WebElement enterTokenName(){
        return this.tokenName;
    }

    public WebElement enterTokenEXP() {
        return this.tokeexp;
    }

   }


