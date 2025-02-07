package automationframework.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage
{
    AndroidDriver driver;
    public FormPage(AndroidDriver driver)
{
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Gayatri");
    //driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();

    @AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
    private WebElement femaleOption;


}

