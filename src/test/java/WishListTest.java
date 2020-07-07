import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishListTest {
    private WebDriver driver;


    @Before
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addItemToWishList() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertEquals("Hello, Mihai NFS !",welcomeMessage.getText());
        driver.findElement(By.cssSelector(".nav-5")).click();
        driver.findElement(By.cssSelector(" li:nth-child(1) div div.actions ul li:nth-child(1) a")).click();
        WebElement confirmMsg = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertTrue(confirmMsg.isDisplayed());
        Assert.assertEquals("Racer Back Maxi Dress has been added to your wishlist. Click here to continue shopping.", confirmMsg.getText());
    }

    @Test
    public void addItemToWishListAndChangeQuantity() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertEquals("Hello, Mihai NFS !",welcomeMessage.getText());
        driver.findElement(By.cssSelector(".nav-5")).click();
        driver.findElement(By.cssSelector(" li:nth-child(1) div div.actions ul li:nth-child(1) a")).click();
        WebElement confirmMsg = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertTrue(confirmMsg.isDisplayed());
        Assert.assertEquals("Racer Back Maxi Dress has been added to your wishlist. Click here to continue shopping.", confirmMsg.getText());
        driver.findElement(By.cssSelector(".add-to-cart-alt .input-text")).click();
        driver.findElement(By.cssSelector(".add-to-cart-alt .input-text")).clear();
        driver.findElement(By.cssSelector(".add-to-cart-alt .input-text")).click();
        driver.findElement(By.cssSelector(".add-to-cart-alt .input-text")).sendKeys("10");
        driver.findElement(By.cssSelector(".buttons-set2 [title='Update Wishlist']")).click();
        WebElement quantity = driver.findElement(By.cssSelector("[value='10']"));
        Assert.assertTrue(quantity.isDisplayed());
    }

    @Test
    public void addItemToWishListWithoutLogin() {
        driver.findElement(By.cssSelector(".nav-5")).click();
        driver.findElement(By.cssSelector(" li:nth-child(1) div div.actions ul li:nth-child(1) a")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertEquals("LOGIN",loginButton.getText());

    }

    @Test
    public void removeItemFromWishList() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertEquals("Hello, Mihai NFS !",welcomeMessage.getText());
        driver.findElement(By.cssSelector(".nav-5")).click();
        driver.findElement(By.cssSelector(" li:nth-child(1) div div.actions ul li:nth-child(1) a")).click();
        WebElement confirmMsg = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertTrue(confirmMsg.isDisplayed());
        Assert.assertEquals("Racer Back Maxi Dress has been added to your wishlist. Click here to continue shopping.", confirmMsg.getText());
        driver.findElement(By.cssSelector(".btn-remove2")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement noItem = driver.findElement(By.cssSelector(".wishlist-empty"));
        Assert.assertTrue(noItem.isDisplayed());
        Assert.assertEquals("You have no items in your wishlist.",noItem.getText());
    }

    @Test
    public void addFromWishListToCart() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cj01nfs@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertEquals("Hello, Mihai NFS !",welcomeMessage.getText());
        Actions action = new Actions(driver);
        WebElement elementHomeDeco = driver.findElement(By.cssSelector("li.nav-4"));
        action.moveToElement(elementHomeDeco).perform();
        driver.findElement(By.cssSelector("li .level1.nav-4-2.menu-active")).click();
        driver.findElement(By.cssSelector("li a[href*='wishlist/index/add/product/378']")).click();
        WebElement wishlist = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(wishlist.isDisplayed());
        Assert.assertEquals("Body Wash with Lemon Flower Extract and Aloe Vera has been added to your wishlist. Click here to continue shopping.",wishlist.getText());
        driver.findElement(By.cssSelector("[onclick='addAllWItemsToCart()']")).click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("h1"));
        Assert.assertTrue(shoppingCart.isDisplayed());
        Assert.assertEquals("SHOPPING CART",shoppingCart.getText());
        WebElement productAddedToShoppCart = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertTrue(productAddedToShoppCart.isDisplayed());
        Assert.assertEquals("1 product(s) have been added to shopping cart: \"Body Wash with Lemon Flower Extract and Aloe Vera\".",productAddedToShoppCart.getText());
    }

    @Ignore
    public void exitSite() {
        driver.quit();
    }
}

