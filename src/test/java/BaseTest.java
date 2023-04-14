import configuration.ConfigRetriever;
import factories.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeEach
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        driver.get(ConfigRetriever.getConfig().getUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
