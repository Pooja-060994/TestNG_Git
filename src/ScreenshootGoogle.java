import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenshootGoogle {

	@Test
	public void TestJavaS1() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\Automated_Tools\\WorkspacePooja\\DemoDataProvider\\src\\Browser_Drivers\\chromedriver.exe");

		// Open Firefox
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// call method
		ScreenshootGoogle.captureScreenShot(driver);
		// Pass the url
		driver.get("http://www.google.com");
		ScreenshootGoogle.captureScreenShot(driver);

	}

	public static void captureScreenShot(WebDriver ldriver) throws Throwable {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		// try {
		// now copy the screenshot to desired location using copyFile method

		Files.copy(src, new File("D:/Demo_selenium/", ".png"));
		/*
		 * } catch (IOException e)
		 * 
		 * { System.out.println(e.getMessage()) ; }
		 */
	}

}
