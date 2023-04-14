package pages;

import configuration.ConfigRetriever;
import configuration.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private EventFiringMouse eventFiringMouse;
    private final WebListener webListener = new WebListener();

    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    protected void initDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigRetriever.getConfig().getWait()));
    }

    protected void clickOnButton(WebElement element) {
        String webElementText = element.getText();
        waitToBeClickable(element);
        element.click();
        log.info("Element " + webElementText + " has been clicked");
    }

    protected void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Waiting for " + element.getText());
    }

    protected void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Waiting for " + element.getText());
    }

    protected void mouseHover(WebElement element) {
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }

    protected void mouseClick(WebElement element) {
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.click(coordinates);
    }
}
