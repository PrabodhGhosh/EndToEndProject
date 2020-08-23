package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import resources.Utility;

public class Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public String appDataPath= (System.getProperty("user.dir")) + "\\resources\\appdata.properties";

	public WebDriver initializeDriver() throws IOException {
/*		prop = new Properties();
		FileInputStream fis = new FileInputStream((System.getProperty("user.dir")) + "\\resources\\appdata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");*/
		String browserName = Utility.getValue(appDataPath, "Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Utility.getValue(appDataPath, "URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(Utility.getValue((System.getProperty("user.dir")) + "\\resources\\appdata.properties", "ImplicitTimeOut")),
					TimeUnit.SECONDS);
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(Utility.getValue(appDataPath, "URL"));
		}

		else {
			log.info("Not valid browser");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String takeScreenShotOnFailure(String TestName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + TestName + ".png";
		FileUtils.copyFile(file, new File(dest));
		return dest;

	}

}
