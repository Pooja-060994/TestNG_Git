import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class New_Tab_Two {
	public static WebDriver driver;
	public static SoftAssert as=new SoftAssert();
@Test
public static void method()
{
System.setProperty("webdriver.chrome.driver","D:\\Automated_Tools\\Drivers\\chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://google.com");
driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium Tutorials", Keys.ENTER);
driver.findElement(By.partialLinkText("https://www.guru99.com/selenium-tutorial.html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
ArrayList li=new ArrayList(driver.getWindowHandles());
driver.switchTo().window((String) li.get(1));
String get_Title=driver.getTitle();
String exp="Selenium Tutorial for Beginners";
System.out.println(get_Title);
as.assertEquals(get_Title, exp);
as.assertAll();
}
}
