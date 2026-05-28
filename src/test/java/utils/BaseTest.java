@BeforeMethod
public void setUp() {
    WebDriverManager.chromedriver().setup();
    
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--window-size=1920,1080");
    options.addArguments("--remote-allow-origins=*");
    
    driver = new ChromeDriver(options);
    // No usar maximize() en headless, ya tenemos window-size
    // driver.manage().window().maximize();
    
    wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Aumenté a 15
    
    driver.get("https://opensource-demo.orangehrmlive.com/");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
}
