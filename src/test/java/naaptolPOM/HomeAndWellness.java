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

public class HomeAndWellness {
	WebDriver driver;

	@FindBy(xpath = "//div[@class=\"cate_head\"]")
	WebElement shoppingCategoriesLink;

	@FindBy(xpath = "//*/span[@class=\"catIconMenu homeDecor\"]")
	WebElement homeLinenFurnitureLink;

	@FindBy(xpath = "//aside/div/ul/li[5]/a[@class=\"cate_Main\"]")
	WebElement HomeAndWellness;

	@FindBy(xpath = "//input[@id='isexoutStock']")
	WebElement excludeOutOfStockCheckbox;

	@FindBy(xpath = "//input[@id='iscod']")
	WebElement cashOnDeliveryCheckbox;

	@FindBy(xpath = "//img[1][@class=\"square\"]")
	WebElement firstHWItemLink;

	@FindBy(xpath = "//*/a[@onclick=\"javascript:productObj.setSize('0',this)\"]")
	WebElement SelectSize;

	@FindBy(xpath = "//*[text()='Click here to Buy']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@onclick=\"cart.submitOrder()\"]")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//img[@title=\"Online Shopping in India\"]")
	WebElement GoToHomePage;

	public HomeAndWellness(WebDriver driver) {
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

	public void clickOnHomeAndWellness() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(HomeAndWellness));
		HomeAndWellness.click();
	}

	public void filterAndPurchaseHomeAndWellness() {
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

		// Click on the Home and Wellness item
		wait.until(ExpectedConditions.visibilityOf(firstHWItemLink));
		firstHWItemLink.click();

		String parentid = driver.getWindowHandle();

		Set<String> allids = driver.getWindowHandles();

		String expectedtitle = "Online Shopping India, Shop Mobile Phone, Mens & Womens Wear, Jewellery, Home Appliances at Naaptol.com";

		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(SelectSize));
		SelectSize.click();
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
