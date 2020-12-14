import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BringItOnTest {

  private static final String PASTE_NAME = "how to gain dominance among developers";
  private static final String PASTE_CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
          + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
          + "git push origin master --force";

  @BeforeClass
  public static void bringItOn() {
    Selenide.open("https://pastebin.com");
    Selenide.$(By.id("postform-text")).sendKeys(PASTE_CODE);
    Selenide.$(By.id("select2-postform-format-container")).click();
    Selenide.$(By.xpath("//li[contains(text(), 'Bash')]")).click();
    Selenide.$(By.id("select2-postform-expiration-container")).click();
    Selenide.$(By.xpath("//li[contains(text(), '10 Minutes')]")).click();
    Selenide.$(By.id("postform-name")).sendKeys(PASTE_NAME);
    Selenide.$(By.xpath("//button[contains(text(), 'Create New Paste')]")).click();
  }

  @Test
  public void checkIfReceivedTitleMatchesPasteName() {
    Assert.assertEquals(Selenide.$(By.xpath("//div[@class = 'info-top']/h1")).getText(), PASTE_NAME);
  }

  @Test
  public void checkIfSyntaxIsHighlighted() {
    Assert.assertEquals(Selenide.$(By.xpath("//div[@class = 'left']/a")).getText(), "Bash");
  }

  @Test
  public void checkIfReceivedTextMatchesCode() {
    Assert.assertEquals(Selenide.$(By.xpath("//textarea[@class = 'textarea']")).getText(), PASTE_CODE);
  }
}
