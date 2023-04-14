package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product_img_link")
    private WebElement productMiniature;

    @FindBy(css = ".quick-view")
    private WebElement quickViewButton;

    public ProductPage moveMouseToProductMiniature() {
        mouseHover(productMiniature);
        return this;
    }

    public ProductPage clickQuickViewButton() {
        waitToBeVisible(quickViewButton);
        mouseClick(quickViewButton);
        return this;
    }
}