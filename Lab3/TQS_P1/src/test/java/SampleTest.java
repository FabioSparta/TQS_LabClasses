import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
    WebDriver browser;

    @BeforeEach
    void setUp() {
        //CHROME
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/bin/chromedriver");
        //ChromeOptions options = new ChromeOptions().addArguments("browser.startup.homepage", "https://www.ua.pt");
          browser = new ChromeDriver();

        //FIREFOX
         // System.setProperty("webdriver.gecko.driver", "/opt/webdriver/bin/geckodriver");
         //browser= new FirefoxDriver();

        //OPERA
        //System.setProperty("webdriver.opera.driver", "/home/fabiosparta/Desktop/TQS/operadriver_linux64/operadriver");
        //browser = new OperaDriver();
    }
    @AfterEach
    void tearDown() { browser.close();
    }

    @Test
    void site_header_is_on_home_page(){
        WebDriverWait wait = new WebDriverWait(browser, 5 );
        browser.get("https://www.saucelabs.com");
        WebElement href= wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='https://accounts.saucelabs.com/']")));
        assertTrue(href.isDisplayed());
    }
}