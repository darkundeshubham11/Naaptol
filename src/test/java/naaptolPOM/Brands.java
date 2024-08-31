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

public class Brands {
	WebDriver driver;

	@FindBy(xpath = "//div[@class=\"cate_head\"]")
	WebElement shoppingCategoriesLink;

	@FindBy(xpath = "//*/span[@class=\"catIconMenu homeDecor\"]")
	WebElement homeLinenFurnitureLink;

	@FindBy(xpath = "//a[@title=\"Branded\"]")
	WebElement Branded;

	@FindBy(xpath = "//img[@src=\"//images.naptol.com/usr/local/csp/staticContent/product_images/horizontal/185x185/Waterproof-Double-Bed-Mattress-Protector-2-Pillow-Protector-Free-DMP8-1.jpg\"]")
	WebElement firstBItemLink;

	@FindBy(xpath = "//li[3]/a[@onclick=\"javascript:productObj.setColor('0',this)\"]")
	WebElement SelectColor;

	@FindBy(xpath = "//*[text()='Click here to Buy']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@onclick=\"cart.submitOrder()\"]")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//img[@title=\"Online Shopping in India\"]")
	WebElement GoToHomePage;

	public Brands(WebDriver driver) {
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

	public void clickOnBranded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Branded));
		Branded.click();
	}

	public void filterAndPurchaseBranded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Click on the Brands item
		wait.until(ExpectedConditions.visibilityOf(firstBItemLink));
		firstBItemLink.click();

		String parentid = driver.getWindowHandle();

		Set<String> allids = driver.getWindowHandles();

		String expectedtitle = "Buy SG 7 Pcs Track Suit + Bag + Safety Kit - Pick Any 1 Online at Best Price in India on Naaptol.com";

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
