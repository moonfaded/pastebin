import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ICanWinTest {

  @FindBy (id = "postform-text")
  private WebElement PASTE_CODE_AREA;

  @FindBy (id = "select2-postform-expiration-container")
  private WebElement EXPIRATION_TIME_FIELD;

  @FindBy (xpath = "//li[contains(text(), '10 Minutes')]")
  private WebElement TEN_MINUTES_EXPIRATION_OPTION;

  @FindBy (id = "postform-name")
  private WebElement PASTE_NAME;

  @FindBy (xpath = "//button[contains(text(), 'Create New Paste')]")
  private WebElement CREATE_PASTE_BUTTON;

  @Test
  public  void iCanWin() {
    PageFactory.initElements(Selenide, this);
    Selenide.open("https://pastebin.com");
    Selenide.$(PASTE_CODE_AREA).sendKeys("Hello from WebDriver");
    Selenide.$(EXPIRATION_TIME_FIELD).click();
    Selenide.$(TEN_MINUTES_EXPIRATION_OPTION).click();
    Selenide.$(PASTE_NAME).sendKeys("helloweb");
    Selenide.$(CREATE_PASTE_BUTTON).click();
  }
}
