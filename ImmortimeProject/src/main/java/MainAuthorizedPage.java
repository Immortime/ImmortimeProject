import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainAuthorizedPage extends BasePageObject {

    public MainAuthorizedPage(WebDriver driver) {
        super(driver);
    }

    public final static String buttonNewXpathLocator = "//aside//a[contains(@class, 'btn btn-sm btn-primary')]";
    public final static String repositoryThatWeAreCreatingForTest = "//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]";
    private final static String profileSettingsButtonInDropDownMenuXpath = "//details//a[contains(@href, '/settings/profile')]";

    @FindBy(xpath = buttonNewXpathLocator)
    WebElement buttonNewToCreateRepository;

    @FindBy(xpath = "//aside//div[contains(@class, 'wb-break-word')]//a[contains(@href, '/SashokTest/Something1')]")
    WebElement newCreatedRepository;

    @FindBy(xpath = "//a[contains(text(), 'Marketplace')]")
    WebElement marketplaceButton;

    @FindBy(xpath = "//summary[contains(@aria-label, 'View profile and more')]")
    WebElement headerProfileStaffDropDownMenu;

    @FindBy(xpath = "//details//a[contains(@href, '/settings/profile')]")
    WebElement profileSettingsButtonInDropDownMenu;

    @Step("Кликнуть на создание нового репозитория")
    public RepositoryCreationMenuPage clickNewForRep() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonNewXpathLocator)));
        buttonNewToCreateRepository.click();
        return new RepositoryCreationMenuPage(driver);
    }

    @Step("Проверка на наличие репозитория")
    public void checkForRepository() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(repositoryThatWeAreCreatingForTest)));
    }

    @Step("Кликнуть на новый созданный репозиторий")
    public NewRepositoryPage clickOnNewCreatedRepository() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(repositoryThatWeAreCreatingForTest)));
        newCreatedRepository.click();
        return new NewRepositoryPage(driver);
    }

    @Step ("Кликнуть на кнопку Marketplace")
    public MarketplaceMainPage clickOnMarketplaceButton() {
        marketplaceButton.click();
        return new MarketplaceMainPage(driver);
    }

    @Step("Перейти в настройки профиля")
    public ProfileSettingsPage goToProfileSettings() {
        headerProfileStaffDropDownMenu.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileSettingsButtonInDropDownMenuXpath)));
        profileSettingsButtonInDropDownMenu.click();
        return new ProfileSettingsPage(driver);
    }
}
