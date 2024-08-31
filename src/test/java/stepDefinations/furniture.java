package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import naaptolPOM.Furniture;
import naaptolPOM.TestCases;

public class furniture {

	WebDriver driver = new ChromeDriver();
	Furniture furniture = new Furniture(driver);
	TestCases testCases = new TestCases();

	@Given("I have navigated to the Furniture section")
	public void i_have_navigated_to_the_furniture_section() {
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		furniture.navigateToHomeLinenFurniture();
	}

	@Given("I am on the Furniture category page")
	public void i_am_on_the_furniture_category_page() {

		furniture.clickOnfurniture();
	}

	@When("I click on the Storage Cabinets section")
	public void i_click_on_the_storage_cabinets_section() {
		furniture.clickOnStorageCabinets();
	}

	@When("I filter the Storage Cabinets based on my preference")
	public void i_filter_the_storage_cabinets_based_on_my_preference() {
		furniture.filterAndPurchaseStorageCabinets();
	}

	@When("Close Browser")
	public void close_browser() {
		driver.quit();
	}
}
