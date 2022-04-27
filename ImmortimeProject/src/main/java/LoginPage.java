import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePageObject {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public static final String incorrectPasswordOrUsernameToolBoxXPath = "//div[contains(@class, 'px-2')]";

    MainAuthorizedPage mainAuthorizedPage = new MainAuthorizedPage(driver);

    @FindBy(xpath = "//input[@id='login_field']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@name, 'commit')]")
    WebElement buttonSignIn;

    @Step("Логин")
    public MainAuthorizedPage login(String email, String password) {
        emailInput.click();
        emailInput.sendKeys(email);
        passwordInput.click();
        passwordInput.sendKeys(password);
        buttonSignIn.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainAuthorizedPage.buttonNewXpathLocator)));
        return mainAuthorizedPage;
    }
}
