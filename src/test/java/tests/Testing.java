package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chandanjavaregowda on 07/12/16.
 */
public class Testing {
    public static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "083c39a50c79555f");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("newCommandTimeout", "600");

        capabilities.setCapability("appPackage", "com.lykehq");
        capabilities.setCapability("appActivity", "com.lykehq.ui.intro.SplashActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void example() throws Exception {
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.support.v7.app.ActionBar.b[2]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")).click();
        driver.findElement(By.id("com.lykehq:id/browse_fragment_view_search")).click();

        driver.findElement(By.id("com.lykehq:id/search_fragment_view_search_query")).click();
        driver.findElement(By.id("com.lykehq:id/search_fragment_view_search_query")).sendKeys("jumpsuit");

        Thread.sleep(2000);

        driver.findElements(By.id("com.lykehq:id/search_item")).get(0).click();

        driver.findElements(By.id("com.lykehq:id/product_container")).get(0).click();
        driver.findElement(By.id("com.lykehq:id/product_details_text_view_description")).click();

        driver.findElement(By.id("com.lykehq:id/product_details_flowLayout")).click();
        driver.findElement(By.id("com.lykehq:id/product_details_text_view_description")).click();
    }
}
