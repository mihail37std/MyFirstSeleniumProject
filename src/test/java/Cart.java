import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLBaseElement;

public class Cart {
    private WebDriver driver;

    @Before
    public void enterSite() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addItemToCart() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[6]/a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > h2 > a")).click();
        driver.findElement(By.cssSelector("#swatch20 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement addedToShopCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(addedToShopCart.isDisplayed());
        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.",addedToShopCart.getText());
    }

    @Test
    public void removeItemFromCart() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[6]/a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > h2 > a")).click();
        driver.findElement(By.cssSelector("#swatch20 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement addedToShopCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(addedToShopCart.isDisplayed());
        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.",addedToShopCart.getText());
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.a-center.product-cart-remove.last > a")).click();
        WebElement shopCartEmpty = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertTrue(shopCartEmpty.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY",shopCartEmpty.getText());
    }

    @Test
    public void editQuantityInCart() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[6]/a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > h2 > a")).click();
        driver.findElement(By.cssSelector("#swatch20 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement addedToShopCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(addedToShopCart.isDisplayed());
        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.",addedToShopCart.getText());
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > li > a")).click();
        driver.findElement(By.id("qty")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("2");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement cartUpdated = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(cartUpdated.isDisplayed());
        Assert.assertEquals("Modern Murray Ceramic Vase was updated in your shopping cart.",cartUpdated.getText());

    }

    @Test
    public void emptyCart (){
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[6]/a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > h2 > a")).click();
        driver.findElement(By.cssSelector("#swatch20 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement addedToShopCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertTrue(addedToShopCart.isDisplayed());
        Assert.assertEquals("Modern Murray Ceramic Vase was added to your shopping cart.",addedToShopCart.getText());
        driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
        WebElement shopCartEmpty = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertTrue(shopCartEmpty.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY",shopCartEmpty.getText());
    }

    @Ignore
    public void exitSite(){
        driver.quit();
    }
}
