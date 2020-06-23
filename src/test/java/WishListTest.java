import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishListTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        addItemToWishList();
        addItemToWishListAndChangeQuantity ();
        addItemToWishListWithoutLogin ();
        removeItemFromWishList();
        addFromWishListToCart ();
    }

    public static void addItemToWishList(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col3-layout > div > " +
                "div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > " +
                "ul > li:nth-child(1) > a")).click();
        driver.quit();
    }

    public static void addItemToWishListAndChangeQuantity (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col3-layout > div > " +
                "div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > " +
                "ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#item_623 > td.wishlist-cell2.customer-wishlist-item-quantity > div > " +
                "div > input")).clear();
        driver.findElement(By.cssSelector("#item_623 > td.wishlist-cell2.customer-wishlist-item-quantity > div > " +
                "div > input")).sendKeys("2");
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-update.button-secondary " +
                "> span > span")).click();
        driver.quit();
    }

    public static void addItemToWishListWithoutLogin (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col3-layout >" +
                " div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom >" +
                " ul.add-to-links > li:nth-child(1) > a")).click();
        driver.quit();
    }

    public static void removeItemFromWishList () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col3-layout > div > " +
                "div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > " +
                "ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#item_632 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }

    public static void addFromWishListToCart () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement elementHomeDeco = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[4]/a"));
        action.moveToElement(elementHomeDeco).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-2 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div" +
                " > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div >" +
                " div.actions > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-add > span > span")).click();
        driver.quit();
    }
}

