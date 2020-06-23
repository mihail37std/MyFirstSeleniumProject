import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        register();
        invalidEmailRegister();
        invalidPasswordRegister ();

    }

    public static void register(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Leonardo");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("Morarii");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Gabriel");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("morarileonardogabriel@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("utilizator");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("utilizator");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.quit();
    }

    public static void invalidEmailRegister(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Popescu");
        driver.findElement(By.id("middlename")).sendKeys("Aurel");
        driver.findElement(By.id("lastname")).sendKeys("Petrica");
        driver.findElement(By.id("email_address")).sendKeys("popescu");
        driver.findElement(By.id("password")).sendKeys("avion");
        driver.findElement(By.id("confirmation")).sendKeys("avion");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();
    }

    public static void invalidPasswordRegister (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Popescu");
        driver.findElement(By.name("middlename")).sendKeys("Aurel");
        driver.findElement(By.name("lastname")).sendKeys("Petrica");
        driver.findElement(By.name("email")).sendKeys("popescu@gmail.com");
        driver.findElement(By.name("password")).sendKeys("avion1");
        driver.findElement(By.name("confirmation")).sendKeys("Avion1");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();
    }
}
