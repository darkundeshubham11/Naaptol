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

public class ShoppingCategoriesPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='cate_head']")
	WebElement shoppingCategoriesLink;

	@FindBy(xpath = "//*/span[@class=\"catIconMenu homeDecor\"]")
	WebElement homeLinenFurnitureLink;

	@FindBy(xpath = "//*/a[@title=\"Blankets & Quilts\"]")
	WebElement blanketsQuiltsLink;

	@FindBy(xpath = "//input[@id='isexoutStock']")
	WebElement excludeOutOfStockCheckbox;

	@FindBy(xpath = "//input[@id='iscod']")
	WebElement cashOnDeliveryCheckbox;

//	@FindBy(xpath = "//input[@id='brandFilterBox38548']")
//	WebElement LuxuryQueenCheckbox;
//
//	@FindBy(xpath = "//input[@id='priceFilterBox2']")
//	WebElement priceCheckbox;
//
//	@FindBy(xpath = "//input[@id='discountFilterBox1']")
//	WebElement DiscountCheckbox;
//
//	@FindBy(xpath = "//input[@id='featureFilterBox0f1']")
//	WebElement TypeCheckbox;
//
//	@FindBy(xpath = "//input[@id='featureFilterBox0f2']")
//	WebElement PatternCheckbox;

	@FindBy(xpath = "//img[1][@class=\"square\"]")
	WebElement firstBlanketItemLink;

	@FindBy(xpath = "//*[text()='Click here to Buy']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@onclick=\"cart.submitOrder()\"]")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//img[@title=\"Online Shopping in India\"]")
	WebElement GoToHomePage;

	public ShoppingCategoriesPage(WebDriver driver) {
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

	public void clickOnBlanketsAndQuilts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(blanketsQuiltsLink));
		blanketsQuiltsLink.click();
	}

	public void filterAndPurchaseBlanket() {
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

//		wait.until(ExpectedConditions.visibilityOf(LuxuryQueenCheckbox));
//		if (!LuxuryQueenCheckbox.isSelected()) {
//			js.executeScript("arguments[0].click();", LuxuryQueenCheckbox);
//		}

//		wait.until(ExpectedConditions.visibilityOf(priceCheckbox));
//		if (!priceCheckbox.isSelected()) {
//			js.executeScript("arguments[0].click();", priceCheckbox);
//		}

//		wait.until(ExpectedConditions.visibilityOf(DiscountCheckbox));
//		if (!DiscountCheckbox.isSelected()) {
//			js.executeScript("arguments[0].click();", DiscountCheckbox);
//		}

//		wait.until(ExpectedConditions.visibilityOf(TypeCheckbox));
//		if (!TypeCheckbox.isSelected()) {
//			js.executeScript("arguments[0].click();", TypeCheckbox);
//		}

//		wait.until(ExpectedConditions.visibilityOf(PatternCheckbox));
//		if (!PatternCheckbox.isSelected()) {
//			js.executeScript("arguments[0].click();", PatternCheckbox);
//		}

		// Click on the first blanket item
		wait.until(ExpectedConditions.visibilityOf(firstBlanketItemLink));
		firstBlanketItemLink.click();

		String parentid = driver.getWindowHandle();

		Set<String> allids = driver.getWindowHandles();

		String expectedtitle = "";

		for (String id : allids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedtitle)) {
				break;
			}
		}
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
