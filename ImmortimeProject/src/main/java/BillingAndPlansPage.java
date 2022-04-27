import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingAndPlansPage extends BasePageObject {

    public BillingAndPlansPage(WebDriver driver) {
        super(driver);
    }

    private static final String buttonEditOnImgBotXpath = "//summary[contains(@class, 'btn-sm btn')]";

    @FindBy(xpath = buttonEditOnImgBotXpath)
    WebElement buttonEditOnImgBot;

    @FindBy(xpath = "//button [contains(text(), 'Cancel plan')]")
    WebElement buttonCancelPlanInEdit;

    @Step("Удалить план ImgBot")
    public ProfileSettingsPage cancelPlanInBillingPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonEditOnImgBotXpath)));
        buttonEditOnImgBot.click();
        buttonCancelPlanInEdit.click();
        driver.switchTo().alert().accept();
        return new ProfileSettingsPage(driver);
    }
}
