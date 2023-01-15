package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    //Attributes
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    //constructor
    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    //page methods
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public boolean waitVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }

    public void waitClick (By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void doubleClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(locator).perform();
    }
}
