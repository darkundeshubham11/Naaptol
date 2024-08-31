package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import naaptolPOM.Decor;
import naaptolPOM.TestCases;

public class decor {

	WebDriver driver = new ChromeDriver();
	Decor decor = new Decor(driver);
	TestCases testCases = new TestCases();

	@Given("I navigate to the Decor category")
	public void i_navigate_to_the_decor_category() {
		driver.get("https://www.naaptol.com/");
		driver.manage().window().maximize();
		decor.navigateToHomeLinenFurniture();
	}

	@Given("I click on Decor")
	public void i_click_on_decor() {
		decor.clickOndecor();
	}

	@When("I filter and purchase a decor")
	public void i_filter_and_purchase_a_decor() {
		decor.filterAndPurchaseDecor();
	}

	@When("close window")
	public void close_window() {
		driver.quit();
	}

}
