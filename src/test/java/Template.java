import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Template {
    public static WebDriver driver;

    @Test
    public void getPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vynoteka.lt");
        driver.findElement(By.id("CookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click(); // cookies
        driver.findElement(By.xpath("//*[@id=\app__inner\]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")); //amzius
        driver.findElement(By.xpath("//*[@id=\omnisend-form-63ff1f31b40d6530aba59a6d-close-icon\]/path")).click(); //leidinys
        driver.findElement(By.xpath("//*[@id=\app\]/div[3]/div/div/div/button/span/svg/use")).click(); //nemokamas pristatymas
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @AfterClass
    public void afterClass() {
        //driver.quit;

    }
}
