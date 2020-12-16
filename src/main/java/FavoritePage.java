
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritePage extends BasePage{

    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    // Favoriler Sayfası
    @FindBy(xpath = "//*[@id=\"myAccount\"]/div/div[2]/ul/li[5]/a")
    private WebElement favorilerClick;

    // Favorilere ekle
    public void clickFavorites() {
        favorilerClick.click();
    }

    public List<WebElement> FavoriteList() {
        return productList;
    }

    // Favori ürünlerin Listesi
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div[2]/div/div/div/div/div/div")
    private List<WebElement> productList;

    // Ürünü Silmek İçin Seçme
    @FindBy(xpath = "//*[@id=\"ProductBox-HBV00000HUL3W\"]/div[1]/div")
    private WebElement chooseProduct;

    // Seçilen Ürün İçin Silme Butonu
    @FindBy(xpath = "(//*[@id=\"StickActionHeader-RemoveSelected\"])[1]")
    private WebElement DeleteProduct1;

    // Silme Onaylama
    @FindBy(xpath = "//*[@id=\"DeleteConfirmationModal-ActionButton\"]")
    private WebElement DeleteProduct2;

    public void DeleteProduct1(){
        chooseProduct.click();
    }
    public void DeleteProduct2(){
        DeleteProduct1.click();
    }

    public void DeleteProduct3(){
        DeleteProduct2.click();
    }



}
