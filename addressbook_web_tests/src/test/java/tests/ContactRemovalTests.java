import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.TestBase;


public class ContactRemovalTests extends TestBase {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1648, 1002));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        }

    }

    @Test
    public void canRemoveContactTest() {
        driver.findElement(By.id("5")).click();
        driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
        //driver.switchTo().alert().getText(), //is("Delete 1 addresses?"));
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("home")).click();
    }
}
