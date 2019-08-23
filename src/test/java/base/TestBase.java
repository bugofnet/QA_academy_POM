package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.General;
import pages.TaskOne;

import java.util.concurrent.TimeUnit;

public class TestBase {
	protected ChromeDriver driver;
	protected TaskOne taskOne;
	protected General general;

	public void start() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
		driver = new ChromeDriver(chromeDriverService, options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		taskOne = PageFactory.initElements(driver, TaskOne.class);
		general = PageFactory.initElements(driver, General.class);
	}

	public void finish() {
		if (driver != null) {
			driver.quit();
		}
	}
}
