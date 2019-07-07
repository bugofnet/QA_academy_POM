package steps;

import base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class Stepdefs extends TestBase {

    @Before
    public void start(){
        super.start();
    }

    @After
    public void finish(){
        super.finish();
    }


    @Given("^I go to test site$")
    public void iGoToTestSite(){
        driver.get("https://testingcup.pgs-soft.com/");
    }

    @When("^I choose \"([^\"]*)\" task$")
    public void iChooseTask(String taskNumber){
        driver.findElement(By.xpath("//h2[.='Zadanie "+taskNumber+"']")).click();
    }


    @And("^I add \"([^\"]*)\" amount for \"([^\"]*)\" product$")
    public void iAddAmountForProduct(String amount, String product){
        taskOne.particularProductAmountFillIn(product, amount);
    }

    @And("^I click add product \"([^\"]*)\" button$")
    public void iClickAddProductButton(String product){
        taskOne.addProductButtonClick(product);
    }

    @Then("^I check that product \"([^\"]*)\" is in the basket with amount \"([^\"]*)\"$")
    public void iCheckThatProductIsInTheBasketWithAmount(String product, String amount){
        taskOne.isProductSumInBusketCorrect(amount);
        taskOne.isProductInBasketAsNeed(product, amount);
    }
}
