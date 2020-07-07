import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;


public class RegisterTest {
    private WebDriver driver;

    @Before
    public void enterSite() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void register(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='create']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Leonardo");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Morarii");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Gabriel");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.cssSelector("#email_address")).sendKeys("morarileonardogabriel"+randomInt+"@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("utilizator");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("utilizator");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
    }

    @Test
    public void invalidEmailRegister(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='create']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Popescu");
        driver.findElement(By.id("middlename")).sendKeys("Aurel");
        driver.findElement(By.id("lastname")).sendKeys("Petrica");
        driver.findElement(By.id("email_address")).sendKeys("popescu");
        driver.findElement(By.id("password")).sendKeys("avion");
        driver.findElement(By.id("confirmation")).sendKeys("avion");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set [title='Register']")).click();
        WebElement createAccount=driver.findElement(By.cssSelector(".page-title"));
        Assert.assertTrue(createAccount.isDisplayed());
        Assert.assertEquals("CREATE AN ACCOUNT",createAccount.getText());
    }

    @Test
    public void invalidPasswordRegister (){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='create']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Popescu");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Aurel");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Petrica");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("popescu@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("avion1");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("Avion1");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set [title='Register']")).click();
        WebElement warrning = driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertTrue(warrning.isDisplayed());
        Assert.assertEquals("Please make sure your passwords match.",warrning.getText());
    }

    @After
    public void exitSite(){
        driver.quit();
    }
}
