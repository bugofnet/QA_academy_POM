package steps;

import base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropFileRead;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Stepdefs extends TestBase {

	@Before
	public void start() {
		super.start();
	}

	@After
	public void finish() {
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
