package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sf-menu>li:nth-of-type(1)>a")
    private WebElement womenCategory;

    @FindBy(css = "(.sf-menu>li:nth-of-type(2)>a")
    private WebElement dressesCategory;

    @FindBy(css = ".submenu-container>li:nth-of-type(1)>ul>li:nth-child(2)>a")
    private WebElement blousesSubcategory;

    public TopMenuPage clickOnWomenCategory() {
        clickOnButton(womenCategory);
        return this;
    }

    public TopMenuPage clickOnDressesCategory() {
        clickOnButton(dressesCategory);
        return this;
    }

    public TopMenuPage moveMouseToWomenCategory() {
        mouseHover(womenCategory);
        return this;
    }

    public void clickOnBlousesSubcategory() {
        waitToBeVisible(blousesSubcategory);
        clickOnButton(blousesSubcategory);
    }
}
