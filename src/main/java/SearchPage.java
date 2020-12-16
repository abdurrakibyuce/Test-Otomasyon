import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //Arama Çubuğu
    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input")
    private WebElement search;

    //Arama Çubuğu Butonu
    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div/div/div[2]")
    private WebElement searchBtn;

    //Arama girişi
    public void submitSearch(String search){
        this.search.clear();
        this.search.sendKeys(search);
    }

    //Arama butonuna tıklama
    public void submitSearchClick(){
        searchBtn.click();
    }

    //Arama Sayfasındaki 2. Button
    @FindBy(xpath = "//*[@id=\"pagination\"]/ul/li[2]/a")
    private WebElement secondButton;

    //2. Sayfaya Geçiş
    public void clickSecondButton() {
        secondButton.click();
    }

    //3. Ürünün Favori Locatoru
    @FindBy(xpath = "(//*[@id=\"heartWrapper\"])[3]")
    private WebElement addToFavoriteButton;

    //Favorilere Ekleme
    public void addToFavorite(){
        addToFavoriteButton.click();
    }

}
