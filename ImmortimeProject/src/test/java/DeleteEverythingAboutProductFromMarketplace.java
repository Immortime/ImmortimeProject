import Helpers.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

//Во всех логинах есть условие - пользователь подтвердил себя по почте

@Story("Тесты на удаление приложений из аккаунта")
public class DeleteEverythingAboutProductFromMarketplace {

    WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://github.com";

    ApplicationsInProfilePage applicationsInProfilePage;

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

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

    @Test
    @Feature("Удаление приложения с акаунта")
    void deleteAppsFromMarketplace() {
        new MainUnAuthorizedPage(driver)
                .clickSignButton()
                .login("nikishkin.sashok@gmail.com", "Testingtesttotest")
                .goToProfileSettings()
                .clickOnBillingAndPlans()
                .cancelPlanInBillingPage()
                .clickOnApplications()
                .clickOnConfigureButton()
                .uninstallApp()
                .revokeAllApps("SashokTest")
                .clickOnIntalledApps();

        Assertions.assertEquals(isElementPresent(By.xpath(applicationsInProfilePage.buttonConfigureXpath)), false);

    }

    @AfterEach
    void shutDown() {
        driver.quit();
    }
}
