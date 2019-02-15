import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandling_ScreenShot {
	WebDriver driver;
	@Test
	public void launchBrowser() throws Throwable
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Automated_Tools\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("window.scrollBy(0,800)");
	
	/*driver.findElement(By.xpath("//button[text()='Confirm Pop up']")).click();
	String exp_Text="Confirm pop up with OK and Cancel button";
	String alert_Text=alt.getText();
	if(exp_Text.equalsIgnoreCase(alert_Text))
	{
	System.out.println(alert_Text);
	alt.accept();
	}
	else
	{
		alt.dismiss();
		System.out.println("Text Not Matched");
	}*/
	driver.findElement(By.xpath("//button[text()='Prompt Pop up']")).click();
	Alert alt=driver.switchTo().alert();
	String exp_Textp="Do you like toolsqa?";
	String alert_Textp=alt.getText();
	if(exp_Textp.equalsIgnoreCase(alert_Textp))
	{
	System.out.println(alert_Textp);
	alt.sendKeys("Yes");
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	alt.accept();
	}
	else
	{
		alt.dismiss();
		System.out.println("Text Not Matched");
	}
	
	
}
}
