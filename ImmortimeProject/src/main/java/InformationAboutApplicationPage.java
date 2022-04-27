import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InformationAboutApplicationPage extends BasePageObject {

    public InformationAboutApplicationPage(WebDriver driver) {
        super(driver);
    }

    private final static String buttonAppUninstallXpath = "//input[contains(@value, 'Uninstall')]";

    @FindBy(xpath = "//input[contains(@value, 'Uninstall')]")
    WebElement buttonAppUninstall;

    public ApplicationsInProfilePage uninstallApp() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonAppUninstallXpath)));
        buttonAppUninstall.click();
        driver.switchTo().alert().accept();
        return new ApplicationsInProfilePage(driver);
    }
}
