package naaptolPOM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BedAndBath {
	WebDriver driver;

	@FindBy(xpath = "//div[@class=\"cate_head\"]")
	WebElement shoppingCategoriesLink;

	@FindBy(xpath = "//*/span[@class=\"catIconMenu homeDecor\"]")
	WebElement homeLinenFurnitureLink;

	@FindBy(linkText = "Bed & Bath")
	WebElement BedAndBath;

	@FindBy(linkText = "Covers")
	WebElement Cover;

	@FindBy(xpath = "//input[@id='isexoutStock']")
	WebElement excludeOutOfStockCheckbox;

	@FindBy(xpath = "//input[@id='iscod']")
	WebElement cashOnDeliveryCheckbox;

	@FindBy(xpath = "//img[1][@class=\"square\"]")
	WebElement firstItemLink;

	@FindBy(linkText = "Cream")
	WebElement SelectColor;

	@FindBy(xpath = "//*[text()='Click here to Buy']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@onclick=\"cart.submitOrder()\"]")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//img[@title=\"Online Shopping in India\"]")
	WebElement GoToHomePage;

	public BedAndBath(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomeLinenFurniture() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(shoppingCategoriesLink));
		shoppingCategoriesLink.click();

		wait.until(ExpectedConditions.visibilityOf(homeLinenFurnitureLink));
		homeLinenFurnitureLink.click();
	}

	public void clickOnBedAndBath() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(BedAndBath));
		BedAndBath.click();
	}

	public void clickOnCover() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Cover));
		Cover.click();
	}

	public void filterAndPurchasebedandbath() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Click on the "Exclude Out Of Stock" checkbox
		wait.until(ExpectedConditions.visibilityOf(excludeOutOfStockCheckbox));
		if (!excludeOutOfStockCheckbox.isSelected()) {
			js.executeScript("arguments[0].click();", excludeOutOfStockCheckbox);
		}

		// Click on the "Cash on Delivery" checkbox
		wait.until(ExpectedConditions.visibilityOf(cashOnDeliveryCheckbox));
		if (!cashOnDeliveryCheckbox.isSelected()) {
			js.executeScript("arguments[0].click();", cashOnDeliveryCheckbox);
		}

		// Click on the Storage item
		wait.until(ExpectedConditions.visibilityOf(firstItemLink));
		firstItemLink.click();

		String parentid = driver.getWindowHandle();

		Set<String> allids = driver.getWindowHandles();

		String expectedtitle = "";

		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(SelectColor));
		SelectColor.click();
		// Click on "Add to Cart"
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();

		// Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
		proceedToCheckoutButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(GoToHomePage));
		GoToHomePage.click();
	}
}
