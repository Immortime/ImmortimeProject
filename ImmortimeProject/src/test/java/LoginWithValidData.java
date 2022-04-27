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

@Story("Логин c валидными данными")
public class LoginWithValidData {

    WebDriver driver;
    private final String MAIN_PAGE_URL = "https://github.com";

    MainAuthorizedPage mainAuthorizedPage;

    @BeforeAll
    static void startDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(MAIN_PAGE_URL);
    }

    @Test
    @Feature("Проверка на логин пользователя и наличия кнопки New")
    void checkForToolTip() {
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest");
        Assertions.assertEquals(driver.findElement(By.xpath(mainAuthorizedPage.buttonNewXpathLocator)).isDisplayed(), true);
    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
