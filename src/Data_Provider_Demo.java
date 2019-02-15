import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Xlr_reader.Xls_Reader;

public class Data_Provider_Demo {
	public static WebDriver driver;

	// SoftAssert sa = new SoftAssert();
	@BeforeSuite
	public void l_browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automated_Tools\\WorkspacePooja\\DemoDataProvider\\src\\Browser_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters("browser")
	public void launchbrowser(String browser) throws InterruptedException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Automated_Tools\\WorkspacePooja\\DemoDataProvider\\src\\Browser_Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Automated_Tools\\WorkspacePooja\\DemoDataProvider\\src\\Browser_Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
		} catch (Exception e) {
			System.out.println("No Browser Found");
		}
	}

	@BeforeClass
	public void app_Launch() {
		driver.get("https://www.facebook.com");
	}

	@DataProvider
	public String[][] ReadData() {
		String sheet_name = System.getProperty("user.dir") + "\\src\\TestData\\TestDataDataPR.xlsx";
		System.out.println("the sheet path is:" + sheet_name);
		Xls_Reader xlrpath = new Xls_Reader(sheet_name);
		int row_count = xlrpath.getRowCount("Sheet1");
		System.out.println("The Total Row In Sheet:" + row_count);
		int col_count = xlrpath.getColumnCount("Sheet1");
		System.out.println("The Total column In Sheet:" + col_count);
		String[][] data_arr = new String[row_count - 1][col_count];
		int ci = 0;
		for (int i = 2; i <= row_count; i++, ci++) {
			int cj = 0;
			for (int j = 0; j < col_count; j++, cj++) {
				data_arr[ci][cj] = xlrpath.getCellData("Sheet1", j, i);
				System.out.println(data_arr[ci][cj]);
			}

			System.out.println(Arrays.toString(data_arr));

		}
		return data_arr;
	}

	@Test(dataProvider = "ReadData")
	public void Registration_data(String UserName, String Password) throws Exception {
		// driver.findElement(By.id("email")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(UserName);
		System.out.println(UserName);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(Password);
		System.out.println(Password);
		driver.findElement(By.id("loginbutton")).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		  driver.findElement(By.xpath("//a[@id='pageLoginAnchor']")).click();
		  WebDriverWait wait = new WebDriverWait(driver, 30); 
		  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By. xpath("//span[text()='Log Out']"))); 
		  element.click();
		 
	}

	/*
	 * @AfterClass public void quitdriver() { driver.quit(); }
	 */

}