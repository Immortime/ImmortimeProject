import Helpers.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

//Во всех логинах есть условие - пользователь подтвердил себя по почте

@Story("Добавление расширения для GitHub")
public class AuthorizeProductFromMarketplace {

    WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://github.com";

    @BeforeAll
    static void startDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
    }

    ProductAskForPermissionPage productAskForPermissionPage;

    @Test
    @Feature("Добавить ImgBot")
    void authorizeProduct() {
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest")
                .clickOnMarketplaceButton()
                .clickOnAppOrActionByName("Imgbot")
                .takeImgBotOnFreeTrial()
                .clickOnButtonOrder()
                .clickOnInstallationButton()
                .confirmUserPasswordIsNeeded("Testingtesttotest")
                .clickOnAuthorizeImgBotButton();
        Assertions.assertEquals(driver.findElement(By.xpath(productAskForPermissionPage.imgBotWasAddedXpath)).isDisplayed(), true);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
