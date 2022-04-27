import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAskForPermissionPage extends BasePageObject {

    public ProductAskForPermissionPage(WebDriver driver) {
        super(driver);
    }

    public final static String imgBotWasAddedXpath = "//a[contains(@class, 'navbar-brand')]";
    private final static String btnPrimaryDisabledAttributeCssSelector = ".btn-primary:disabled";

    @FindBy(css = ".btn-primary")
    WebElement authorizeProductButton;

    @Step("Кликнуть по кнопке авторизовать ImgBot")
    public void clickOnAuthorizeImgBotButton() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(btnPrimaryDisabledAttributeCssSelector)));
        authorizeProductButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(imgBotWasAddedXpath)));
    }
}
