import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        Login login = new Login();
        login.login();
        login.invalidPasswordLogin();
        login.invalidEmailLogin();






    }


}
