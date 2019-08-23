package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class General {
	public General(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver driver;

	public void buttonClick(String buttonName) {
		driver.findElement(By.xpath("//button[.='" + buttonName + "']")).click();
	}
}
