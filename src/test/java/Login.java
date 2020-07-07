import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;

    @Before
    public void openSite (){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void login(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertEquals("Hello, Mihai NFS !",welcomeMessage.getText());
    }

    @Test
    public void invalidEmailLogin(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement invalidMessage = driver.findElement(By.cssSelector("li span"));
        Assert.assertTrue(invalidMessage.isDisplayed());
        Assert.assertEquals("Invalid login or password.",invalidMessage.getText());
    }

    @Test
    public void invalidPasswordLogin(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123459");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement invalidMessage = driver.findElement(By.cssSelector("li span"));
        Assert.assertTrue(invalidMessage.isDisplayed());
        Assert.assertEquals("Invalid login or password.",invalidMessage.getText());
    }

    @After
    public void exitSite (){
        driver.quit();
    }


}
