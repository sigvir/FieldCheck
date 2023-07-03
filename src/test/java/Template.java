import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void FillSearch() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("reset")).click(); // reset button
        driver.findElement(By.id("search")).sendKeys("Plaukimas baidaremis");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();
        String searchResult = driver.findElement(By.id("search-result")).getText();
        System.out.println(searchResult.equals("Plaukimas baidaremis") ? "search pass" : "search fail");
        Thread.sleep(200);//veikia
    }

    @Test
    public void fillName() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("name")).sendKeys("Vardenis");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();
        String nameResult = driver.findElement(By.id("name-result")).getText();
        System.out.println(nameResult.equals("Vardenis") ? "name pass" : "name fail");
        Thread.sleep(200);//veikia
    }

    @Test
    public void fillPasword() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("password")).sendKeys("Pavardenis");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();
        String passwordResult = driver.findElement(By.id("password-result")).getText();
        System.out.println(passwordResult.equals("Pavardenis") ? "password pass" : "password fail");
        Thread.sleep(200);
    }

    @Test
    public void fillEmail() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("email")).sendKeys("vardenis.pavardenis@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();
        String emailResult = driver.findElement(By.id("email-result")).getText();
        System.out.println(emailResult.equals("vardenis.pavardenis@gmail.com") ? "email pass" : "email fail");
        Thread.sleep(200);//veikia
    }

    @Test
    public void fillAge() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();
        String ageResult = driver.findElement(By.id("age-result")).getText();
        System.out.println(ageResult.equals("25") ? "age pass" : "age fail");
        Thread.sleep(200);//veikia
    }

    @Test
    public void checkBoxes() throws InterruptedException { //veikia, failure seats result, nes ne 1, 3
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("sleepInBed")).click(); // kur miegosim varnele
        driver.findElement(By.id("HaveMeal")).click();//ar valgysim varnele
        driver.findElement(By.id("mid")).click(); //plaukimo viduryje
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();//push touch me
        String sleepInBedResult = driver.findElement(By.id("sleepInBed-result")).getText();
        System.out.println(sleepInBedResult.equals("Yes") ? "sleepInBed pass" : "sleepInBed fail");
        String HaveMealResult = driver.findElement(By.id("HaveMeal-result")).getText();
        System.out.println(HaveMealResult.equals("Yes") ? "HaveMeal pass" : "HaveMeal fail");
        driver.findElement(By.xpath("/html/body/form/select/option[3]")).click();// click option triple
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click(); //push touch me

        //***Parking check***///
        driver.findElement(By.id("parking-result-start")).getText();
        String parkingResultStart = driver.findElement(By.id("parking-result-start")).getText();
        System.out.println(parkingResultStart.equals("Yes") ? "parkingResultStart pass" : "parkingResultStart fail");
        Thread.sleep(100);

        String parkingResultMid = driver.findElement(By.id("parking-result-mid")).getText();
        System.out.println(parkingResultMid.equals("Yes") ? "parkingResultMid pass" : "parkingResultMid fail");
        Thread.sleep(100);

        String parkingResultEnd = driver.findElement(By.id("parking-result-end")).getText();
        System.out.println(parkingResultEnd.equals("Yes") ? "parkingResultEnd pass" : "parkingResultEnd fail");
        Thread.sleep(100);

        Assert.assertEquals(driver.findElement(By.id("seats-result")).getText(), 1); //patikrina

    }

    @Test
    public void radioButtonCheck() {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.id("start")).click();
        driver.findElement(By.id("mid")).click();
        driver.findElement(By.id("end")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();//push touch me

        Assert.assertEquals(driver.findElement(By.id("start")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("mid")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("end")).isSelected(), true);//option 3 chosen?

        Assert.assertEquals(driver.findElement(By.id("parking-result-start")).getText(), "No");
        Assert.assertEquals(driver.findElement(By.id("parking-result-mid")).getText(), "No");
        Assert.assertEquals(driver.findElement(By.id("parking-result-end")).getText(), "Yes");

    }

    @Test
    public void timeCheck() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.xpath("//*[@id=\"time\"]")).sendKeys("0940AM");
        driver.findElement(By.name("date")).sendKeys("10/15/2023"); //veikia
        driver.findElement(By.name("datetime-local")).sendKeys("07/01/2023");
        driver.findElement(By.name("datetime-local")).sendKeys(Keys.TAB);
        Thread.sleep(100);
        driver.findElement(By.name("datetime-local")).sendKeys("15:15PM");
        driver.findElement(By.name("month")).sendKeys("July"); //neparenka metu, tik menesi
        driver.findElement(By.name("month")).sendKeys(Keys.TAB);
        driver.findElement(By.name("month")).sendKeys("2025");
        Thread.sleep(100);
        driver.findElement(By.name("week")).sendKeys("Week51,2023");
        driver.findElement(By.xpath("//*[@id=\"form\"]/button")).click();//push touch me


    }


    // @BeforeMethod
    //  public void beforeMethod() {

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();

    }

}
