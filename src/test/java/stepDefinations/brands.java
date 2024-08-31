package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import naaptolPOM.Brands;
import naaptolPOM.TestCases;

public class brands {
	WebDriver driver = new ChromeDriver();
	Brands brands = new Brands(driver);
	TestCases testCases = new TestCases();

	@Given("I have navigated to the Brands section")
	public void i_have_navigated_to_the_brands_section() {
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		brands.navigateToHomeLinenFurniture();
	}

	@Given("I am on the Branded category page")
	public void i_am_on_the_branded_category_page() {
		brands.clickOnBranded();
	}

	@When("I filter the Branded items based on my preference")
	public void i_filter_the_branded_items_based_on_my_preference() {
		brands.filterAndPurchaseBranded();
	}

	@When("Close Window")
	public void close_window() {
		driver.quit();
	}

}
