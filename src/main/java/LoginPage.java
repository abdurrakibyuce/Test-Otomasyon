import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@id=\"txtUserName\"])[1]")
    private WebElement email;

    @FindBy(xpath = "(//*[@id=\"txtPassword\"])[1]")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(className = "user")
    private WebElement userName;

    public void submit(){
        loginButton.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public void enterLoginForm(String email, String password){
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);
    }

}
