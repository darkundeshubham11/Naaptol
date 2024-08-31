package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import naaptolPOM.ShoppingCategoriesPage;
import naaptolPOM.TestCases;

public class shopping {

	WebDriver driver = new ChromeDriver();
	ShoppingCategoriesPage shoppingCategoriesPage = new ShoppingCategoriesPage(driver);
	TestCases testCases = new TestCases();

	@Given("I navigate to the Home Linen & Furniture category")
	public void i_navigate_to_the_home_linen_furniture_category() {
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		shoppingCategoriesPage.navigateToHomeLinenFurniture();
	}

	@Given("I click on Blankets and Quilts")
	public void i_click_on_blankets_and_quilts() {
		shoppingCategoriesPage.clickOnBlanketsAndQuilts();
	}

	@When("I filter and purchase a blanket")
	public void i_filter_and_purchase_a_blanket() {
		shoppingCategoriesPage.filterAndPurchaseBlanket();
	}

	@Then("take a screenshot of the purchase")
	public void take_a_screenshot_of_the_purchase() {
		driver.quit();
	}

}
