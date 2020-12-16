import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuce\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
