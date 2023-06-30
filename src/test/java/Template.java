import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Template {
    public static WebDriver driver;

    @Test
    public void getPage() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("reset")).click(); // reset button
        driver.findElement(By.id("search")).sendKeys("Plaukimas baidaremis");
        Thread.sleep(200);

        //***data entry**///

        driver.findElement(By.id("name")).sendKeys("Vardenis");
        Thread.sleep(200);
        driver.findElement(By.id("password")).sendKeys("Pavardenis");
        Thread.sleep(200);
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis@gmail.com");
        Thread.sleep(200);
        driver.findElement(By.id("age")).sendKeys("25");
        Thread.sleep(200);

        //***box check***///

        driver.findElement(By.id("sleepInBed")).click(); // kur miegosim varnele
        driver.findElement(By.id("HaveMeal")).click();//ar valgysim varnele
        driver.findElement(By.id("mid")).click(); //plaukimo viduryje
        Thread.sleep(200);
        driver.findElement(By.xpath("/html/body/form/select/option[3]")).click();// click option 3
        // Thread.sleep(200);
        driver.findElement(By.xpath("/html/body/form/button")).click(); // press button

        //***data check ***///

        String nameResult = driver.findElement(By.id("name-result")).getText();
        System.out.println(nameResult.equals("Vardenis") ? "name pass" : "name fail");

        String ageResult = driver.findElement(By.id("age-result")).getText();
        System.out.println(ageResult.equals("25") ? "age pass" : "age fail");

        String searchResult = driver.findElement(By.id("search-result")).getText();
        System.out.println(searchResult.equals("Plaukimas baidaremis") ? "search pass" : "search fail");

        String passwordResult = driver.findElement(By.id("password-result")).getText();
        System.out.println(passwordResult.equals("Plaukimas baidaremis") ? "password pass" : "password fail");

        String emailResult = driver.findElement(By.id("email-result")).getText();
        System.out.println(emailResult.equals("vardenis.pavardenis@gmail.com") ? "email pass" : "email fail");

        String sleepInBedResult = driver.findElement(By.id("sleepInBed-result")).getText();
        System.out.println(sleepInBedResult.equals("Yes") ? "sleepInBed pass" : "sleepInBed fail");

        String HaveMealResult = driver.findElement(By.id("HaveMeal-result")).getText();
        System.out.println(HaveMealResult.equals("Yes") ? "HaveMeal pass" : "HaveMeal fail");

        // if(text.equals("jonas")){
// System.out.println("zodis buvo jonas");
// } else if (text.equals("labas")) {
// System.out.println("zodis buvo labas");
// }else {
// System.out.println("zodis mums nezinomas");


        // Assert.assertEquals(driver.findElement(By.id("name-result")).getText(),"Vardenis");

    }

    // @BeforeMethod
    //  public void beforeMethod() {

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

