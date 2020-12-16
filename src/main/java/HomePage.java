import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private static String baseUrl = "https://www.hepsiburada.com/";

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getLoginPage(){
        login.click();
    }

    public String getUrl() {
        return baseUrl;
    }
}
