package tests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CucumberHooks {

    private WebDriver driver;

    private String browser = "chrome";

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Runs before all scenarios");
    }

    @Before
    public void setup(){

        switch (browser) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalStateException("unexpected value" + browser);

        }

    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Runs after all scenarios");
    }

    public WebDriver getDriver(){
        return driver;
    }
}
