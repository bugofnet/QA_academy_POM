package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskOne {
    public TaskOne(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @FindBy(className = "summary-quantity")
    private WebElement summInBusket;

    public void particularProductAmountFillIn(String product, String amount){
        WebElement element = driver.findElement(By.xpath("//button[@data-product-name='"+product+"']/../following-sibling::input"));
        element.clear();
        element.sendKeys(amount);
    }
    public void addProductButtonClick(String product){
        driver.findElement(By.xpath("//button[@data-product-name='"+product+"']")).click();
    }
    public void isProductSumInBusketCorrect(String amount){
        Assert.assertEquals(summInBusket.getText(),amount);
    }

    public void isProductInBasketAsNeed(String product, String amount){
        WebElement element = driver.findElement(By.xpath("//span[@data-quantity-for='"+product+"']"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),amount);
    }
}
