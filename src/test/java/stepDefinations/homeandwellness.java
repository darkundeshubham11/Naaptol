package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import naaptolPOM.HomeAndWellness;
import naaptolPOM.TestCases;

public class homeandwellness {
	WebDriver driver = new ChromeDriver();
	HomeAndWellness homeAndWellness = new HomeAndWellness(driver);;
	TestCases testCases = new TestCases();

	@Given("I have navigated to the Home Linen and Furniture section")
	public void i_have_navigated_to_the_home_linen_and_furniture_section() {
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		homeAndWellness.navigateToHomeLinenFurniture();
	}

	@Given("I am on the Home and Wellness category page")
	public void i_am_on_the_home_and_wellness_category_page() {
		homeAndWellness.clickOnHomeAndWellness();
	}

	@When("I filter the items based on my preference select an item to purchase")
	public void i_filter_the_items_based_on_my_preference_select_an_item_to_purchase() {
		homeAndWellness.filterAndPurchaseHomeAndWellness();
	}

	@When("close browser")
	public void close_browser() {
		driver.quit();
	}

}
