import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BringItOnTest {

  @Test
  public static void bringItOn() {
    Selenide.open("https://pastebin.com");
    Selenide.$(By.id("postform-text")).sendKeys("git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force");
    Selenide.$(By.id("select2-postform-format-container")).click();
    Selenide.$(By.xpath("//li[contains(text(), 'Bash')]")).click();
    Selenide.$(By.xpath("//li[contains(text(), '10 Minutes')]")).click();
    Selenide.$(By.id("postform-name")).sendKeys("Selenide.$(By.id(\"postform-name\")).sendKeys(\"helloweb\");");
    Selenide.$(By.xpath("//button[contains(text(), 'Create New Paste')]")).click();
  }
}
