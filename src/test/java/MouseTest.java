import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.ProductPopupPage;
import pages.TopMenuPage;

public class MouseTest extends BaseTest {

    @Test
    public void shouldCheckMiniatures() {
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductPopupPage productPopupPage = new ProductPopupPage(driver);
        topMenuPage.moveMouseToWomenCategory()
                .clickOnBlousesSubcategory();
        productPage.moveMouseToProductMiniature()
                .clickQuickViewButton();
        productPopupPage.waitForPopup()
                .switchToIframe();
        for (int i = 0; i < productPopupPage.getProductMiniatures().size(); i++) {
            productPopupPage.moveMouseToMiniature(i);
            String miniatureSrc = productPopupPage.getProductMiniatures()
                    .get(i)
                    .getAttribute("src")
                    .replace("-cart_default.jpg", "");
            String bigPicSrc = productPopupPage.getBigPic().getAttribute("src").replace("-large_default.jpg", "");
            Assertions.assertEquals(miniatureSrc, bigPicSrc);
        }
    }
}
