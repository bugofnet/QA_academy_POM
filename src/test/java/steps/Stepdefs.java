package steps;

import base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropFileRead;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stepdefs extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(Stepdefs.class);


	@Before
	public void start() {
		super.start();
	}

	@After
	public void finish(Scenario scenario) throws IOException {
		if (!scenario.isFailed()) {
			LOG.info("Scenario successfully passed: " + scenario.getName());
		} else {
			File file = new File("target");
			if (!file.exists()) {
				file.mkdir();
			}
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentTime = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date());
			String screenName = "target/" + "screenshots/" + currentTime + "/" + scenario.getName() + ".png";
			File targetFile = new File(screenName);
			FileUtils.copyFile(screenshotFile, targetFile);
			LOG.info("Scenario is  failed: " + scenario.getName());
			LOG.info("Screenshot " + screenName + " was created");
		}
		super.finish();
	}


	@Given("^I go to test site$")
	public void iGoToTestSite() {
		driver.get(new PropFileRead().getProp("url"));
	}

	@When("^I choose \"([^\"]*)\" task$")
	public void iChooseTask(String taskNumber) {
		driver.findElement(By.xpath("//h2[.='Zadanie " + taskNumber + "']")).click();
	}


	@And("^I add \"([^\"]*)\" amount for \"([^\"]*)\" product with \"([^\"]*)\"$")
	public void iAddAmountForProduct(String amount, String product, String howToFill) {
		taskOne.particularProductAmountFillIn(product, amount, howToFill);
	}

	@And("^I click add product \"([^\"]*)\" button$")
	public void iClickAddProductButton(String product) {
		taskOne.addProductButtonClick(product);
	}

	@Then("^I check that product \"([^\"]*)\" is in the basket with amount \"([^\"]*)\"$")
	public void iCheckThatProductIsInTheBasketWithAmount(String product, String amount) {
		taskOne.isProductSumInBasketCorrect(amount);
		taskOne.isProductInBasketAsNeed(product, amount);
	}

	@When("^I click button \"([^\"]*)\"$")
	public void iClickButton(String buttonName) {
		general.buttonClick(buttonName);
	}

	@Then("^I check that basket is empty$")
	public void iCheckThatBasketIsEmpty() {
		taskOne.isProductSumInBasketCorrect("0");
	}

	@Then("^I see alert message \"([^\"]*)\"$")
	public void iSeePopUpWithMessage(String messageText) {
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(messageText, alert.getText());
	}
}
