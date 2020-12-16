import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

    @Test(priority = 1)
    public void HomePageControl(){

        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        Assert.assertTrue(driver.getTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"));
        System.out.println("Hepsiburada başarılı bir şekilde açıldı.");

    }

    @Test (priority = 2)
    public void LoginPage(){

        Actions actions = new Actions(driver);
        WebElement loginp = driver.findElement(By.xpath("//*[@id=\"myAccount\"]/span/span[1]"));
        actions.moveToElement(loginp).perform();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]")));

        HomePage homePage = new HomePage(driver);
        homePage.getLoginPage();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Üye Giriş Sayfası & Üye Ol - Hepsiburada"));
        System.out.println("Üye Girişi için sayfa başarılı bir şekilde açıldı");

    }

    @Test (priority = 3)
    public void SignIn() throws InterruptedException {

        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterLoginForm("denemeMail@gmail.com", "denemePassword");
        loginPage.submit();

    }

    @Test (priority = 4)
    public void Search() throws InterruptedException {

        Thread.sleep(4000);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.submitSearch("samsung");
        searchPage.submitSearchClick();
        Thread.sleep(2000);
        Assert.assertTrue(!searchPage.equals(""));
        System.out.println("Samsung için sonuç bulundu.");

    }

    @Test (priority = 5)
    public void SecondPage () throws InterruptedException{
        Thread.sleep(3000);
        SearchPage searchPage =new SearchPage(driver);
        searchPage.clickSecondButton();
        Thread.sleep(3000);
        System.out.println("burası : " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.hepsiburada.com/ara?q=samsung&sayfa=2"));
        System.out.println("2. Sayfa başarılı bir şekilde açıldı.");

    }

    @Test (priority = 6)
    public void AddToFavorites () throws InterruptedException {

        Thread.sleep(3000);
        SearchPage searchPage =new SearchPage(driver);
        searchPage.addToFavorite();

    }

    @Test (priority = 7)
    public void FavoritesPage () throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement fav = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
        actions.moveToElement(fav).perform();
        Thread.sleep(2000);

        FavoritePage favoritePage =new FavoritePage(driver);
        favoritePage.clickFavorites();
        System.out.println("Favoriler sayfası açıldı.");


    }

    @Test (priority = 8)
    public void FindFavoriteProduct() throws InterruptedException {

        Thread.sleep(3000);
        FavoritePage favoritePage =new FavoritePage(driver);

        for (WebElement products : favoritePage.FavoriteList()) {
            String listProduct = products.getText();
            System.out.println(listProduct);
            Assert.assertTrue(listProduct.equals("Samsung 970 Evo Plus NVMe 500GB 3500MB/s-3300MB/s M.2 SSD (MZ-V7S500BW)\n" +
                    "929,00 TL"));
        }
    }


    @Test (priority = 9)
    public void DeleteProduct () throws InterruptedException {

        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement favprod = driver.findElement(By.xpath("//*[@id=\"ProductBox-HBV00000HUL3W\"]"));
        actions.moveToElement(favprod).perform();

        Thread.sleep(2000);
        FavoritePage favoritePage =new FavoritePage(driver);
        favoritePage.DeleteProduct1();
        Thread.sleep(1000);
        favoritePage.DeleteProduct2();
        Thread.sleep(1000);
        favoritePage.DeleteProduct3();
        Thread.sleep(1000);

    }


    @Test (priority = 10)
    public void DeleteConfirm() {

        FavoritePage favoritePage =new FavoritePage(driver);
        for (WebElement products : favoritePage.FavoriteList()) {
            String listProduct = products.getText();
            System.out.println(listProduct);
            Assert.assertTrue(!listProduct.equals("Samsung 970 Evo Plus NVMe 500GB 3500MB/s-3300MB/s M.2 SSD (MZ-V7S500BW)\n" +
                    "929,00 TL"));

        }
        System.out.println("Ürün listeden silindi.");

    }


}
