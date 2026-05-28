package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options);
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
