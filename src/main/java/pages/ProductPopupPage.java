package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPopupPage extends BasePage {
    public ProductPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#thumbs_list_frame a[title='Blouse'] img")
    private List<WebElement> productMiniatures;

    @FindBy(css = "#bigpic")
    private WebElement bigPic;

    @FindBy(css = ".fancybox-close")
    private WebElement popupCloseButton;

    @FindBy(css = ".fancybox-iframe")
    private WebElement iframe;

    public List<WebElement> getProductMiniatures() {
        return productMiniatures;
    }

    public ProductPopupPage moveMouseToMiniature(int index) {
        mouseHover(productMiniatures.get(index));
        return this;
    }

    public WebElement getBigPic() {
        return bigPic;
    }

    public ProductPopupPage waitForPopup() {
        waitToBeVisible(popupCloseButton);
        return this;
    }

    public ProductPopupPage switchToIframe() {
        driver.switchTo().frame(iframe);
        return this;
    }
}
