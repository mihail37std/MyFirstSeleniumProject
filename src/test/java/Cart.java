import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        addItemToCart();
        removeItemFromCart();
        changeQuantityInCart();
        emptyCart();
    }

    public static void addItemToCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > " +
                "div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                "li:nth-child(2) > div > h3 > a")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > " +
                "div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.close();
    }

    public static void removeItemFromCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > " +
                "div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                "li:nth-child(2) > div > h3 > a")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > " +
                "div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.a-center.product-cart-remove.last > a")).click();
        driver.quit();
    }

    public static void changeQuantityInCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > " +
                "div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                "li:nth-child(2) > div > h3 > a")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > " +
                "div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).clear();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).sendKeys("2");
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > button")).click();
        driver.quit();
    }

    public static void emptyCart (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > " +
                "div > div > div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                "li:nth-child(2) > div > h3 > a")).click();
        driver.findElement(By.cssSelector("#swatch21 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > " +
                "div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
        driver.close();
    }
}
