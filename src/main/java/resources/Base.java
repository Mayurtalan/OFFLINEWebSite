package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	

		public static  Properties prop;
		public static WebDriver driver;

		public WebDriver getDriver() throws IOException {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			/*
			 * String Browser = prop.getProperty("browser"); String Url
			 * =prop.getProperty("url"); System.out.println(Browser);
			 * System.out.println(Url);
			 * 
			 */
			String Browser = prop.getProperty("browser");

			if (Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("firefox")) {
				System.out.println("This is FirFox Browser");
			}

			return driver;

		}

		public void navigateUrl() throws IOException {
			driver.get(prop.getProperty("url"));
		}

}
