import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ICanWinTest {

  @Test
  public static void iCanWin() {
    Selenide.open("https://pastebin.com");
    Selenide.$(By.id("postform-text")).sendKeys("Hello from WebDriver");
    Selenide.$(By.id("select2-postform-expiration-container")).click();
    Selenide.$(By.xpath("//li[contains(text(), '10 Minutes')]")).click();
    Selenide.$(By.id("postform-name")).sendKeys("helloweb");
    Selenide.$(By.xpath("//button[contains(text(), 'Create New Paste')]")).click();
  }
}
