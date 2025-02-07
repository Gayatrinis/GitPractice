import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.Double.parseDouble;


public class Baseclass {

   public AndroidDriver driver;
   public  AppiumDriverLocalService service;
   @BeforeClass
     public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//eswar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Gayatriphone");
        options.setChromedriverExecutable("");
        //options.setApp("C://Users//eswar//Automationframework//src//test//java//resources//ApiDemos-debug.apk");

       options.setApp("C://Users//eswar//Automationframework//src//test//java//resources//General-store.apk");


         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), (Capabilities) options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void longPressAction(WebElement ele)
    {
        ( (JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
               "elementId", ((RemoteWebElement) ele).getId(),"duration",4000));
    }
   public void swipeAction(WebElement ele,String direction)
    {
      ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
              "elementId", ((RemoteWebElement)ele).getId(),
             "direction", direction,
               "percent", 0.4

        ));
    }




    public static Double getFormattedAmount(String amount) throws NumberFormatException
    {
     Double price1= parseDouble(amount.substring(1));
        price1 = price1;
        return price1;
   }
    @AfterClass
    void teardown()
    {
        driver.quit();
        service.stop();

    }
}