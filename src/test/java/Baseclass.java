import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.Double.parseDouble;


public class Baseclass {

   public AndroidDriver driver;
   public  AppiumDriverLocalService service;
    private String amount;

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
   public void swipeAction(WebElement ele,String direction) {
       ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
               "elementId", ((RemoteWebElement) ele).getId(),
               "direction", direction,
               "percent", 0.4

       ));
       public void DragNDropTest () throws MalformedURLException, InterruptedException
       {

           driver.findElement(new AppiumBy.ByAccessibilityId("Views")).click();
           driver.findElement(new AppiumBy.ByAccessibilityId("Drag and Drop")).click();
           WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
           ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                   "elementId", ((RemoteWebElement) source).getId(),
                   "endX", 625,
                   "endY", 640
           ));
           @Test
           void Miscellaneous() throws MalformedURLException
           {
               Activity activity= new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
               ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent"," io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"

               ));
               DeviceRotation potrait= new DeviceRotation(90,90,0);
               driver.rotate(potrait);

           }


       public static Double getFormattedAmount (String amount) throws NumberFormatException
       {
           Double price1 = parseDouble(amount.substring(1));
           price1 = price1;
           return price1;
       }
       @AfterClass
       void teardown ()
       {
           driver.quit();
           service.stop();

       }
   }