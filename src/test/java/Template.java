import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Template {
    public static WebDriver driver;

    @Test
    public void getPage() throws InterruptedException {
        driver.findElement(By.id("reset")).click(); // reset button
        driver.findElement(By.id("search")).sendKeys("testText");
        Thread.sleep(200);
    }

    @Test
    public void dataFill() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Vardenis");
        Thread.sleep(200);
        driver.findElement(By.id("password")).sendKeys("Pavardenis");
        Thread.sleep(200);
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis@gmail.com");
        Thread.sleep(200);
        driver.findElement(By.id("age")).sendKeys("25");
        Thread.sleep(200);
    }

    @Test
    public void boxCheck() throws InterruptedException {
        driver.findElement(By.id("sleepInBed")).click(); // kur miegosim varnele
        driver.findElement(By.id("HaveMeal")).click();//ar valgysim varnele
        driver.findElement(By.id("mid")).click(); //plaukimo viduryje
        Thread.sleep(200);
        driver.findElements(By.xpath("//*[@id=seats]/option[2]"));


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://127.0.0.1:5500/index.html");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();

    }
}

