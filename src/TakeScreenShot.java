import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakeScreenShot {
	public static WebDriver driver;
	@Test(priority=1)
	public void screenShot() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automated_Tools\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			Files.copy(src, new File("D:/Demo_selenium/error1.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=2)
	public void SearchContent() {
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium Tutorial", Keys.ENTER);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			Files.copy(src, new File("D:/Demo_selenium/error2.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority=3)
	public void move_back() {
		driver.navigate().back();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			Files.copy(src, new File("D:/Demo_selenium/error3.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
