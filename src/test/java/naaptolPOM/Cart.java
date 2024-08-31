package naaptolPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	WebDriver driver;

	@FindBy(xpath = "//span[@class=\"cartIcon\"]")
	WebElement cart;

	@FindBy(linkText = "Remove")
	WebElement Remove1stProduct;

	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();

		wait.until(ExpectedConditions.visibilityOf(Remove1stProduct));
		Remove1stProduct.click();

	}

}
