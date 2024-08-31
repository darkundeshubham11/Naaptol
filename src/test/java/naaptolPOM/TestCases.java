package naaptolPOM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestCases {
	WebDriver driver;
	Decor decor;
	BedAndBath bedAndBath;
	HomeFurnishing homeFurnishing;
	ShoppingCategoriesPage shoppingCategoriesPage;
	Furniture furniture;
	HomeAndWellness homeAndWellness;
	Brands brands;
	Cart cart;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setUp() {
		extent = ExtentReportManager.createInstance("E:\\SDET201\\NaaptolExtentReport\\ExtentReport.html");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
		decor = new Decor(driver);
		bedAndBath = new BedAndBath(driver);
		homeFurnishing = new HomeFurnishing(driver);
		shoppingCategoriesPage = new ShoppingCategoriesPage(driver);
		furniture = new Furniture(driver);
		homeAndWellness = new HomeAndWellness(driver);
		brands = new Brands(driver);
		cart = new Cart(driver);
	}

	@Test
	public void testNavigateToHomeLinenAndFurniture() {
		test = extent.createTest("Test Navigation to Home Linen and Furniture");

		try {
			// Perform actions on Decor category
			test.log(Status.INFO, "Navigating to Home Linen and Furniture");
			decor.navigateToHomeLinenFurniture();

			decor.clickOndecor();
			takeScreenshot("Decor Page Open");
			test.pass("Decor Page Open successful");

			decor.filterAndPurchaseDecor();
			takeScreenshot("Decor");
			test.pass("Decor purchase successful");

			// Perform actions on Bed And Bath Covers category
			test.log(Status.INFO, "Navigating to Home Linen and Furniture");
			bedAndBath.navigateToHomeLinenFurniture();

			bedAndBath.clickOnBedAndBath();
			takeScreenshot("Bed And Bath Page Open");
			test.pass("Bed And Bath Page Open successful");

			bedAndBath.clickOnCover();
			takeScreenshot("Covers Page Open");
			test.pass("Covers Page Open successful");

			bedAndBath.filterAndPurchasebedandbath();
			takeScreenshot("Decor");
			test.pass("Decor purchase successful");

			// Perform actions on Bed And Bath Home Furnishing category
			test.log(Status.INFO, "Navigating to Home Linen and Furniture");
			homeFurnishing.navigateToHomeLinenFurniture();

			homeFurnishing.clickOnBedAndBath();
			takeScreenshot("Bed And Bath Page Open");
			test.pass("Bed And Bath Page Open successful");

			homeFurnishing.clickOnhomeFurnishing();
			takeScreenshot("Home Furnishing Page Open");
			test.pass("Home Furnishing Page Open successful");

			homeFurnishing.filterAndPurchasehomeFurnishing();
			takeScreenshot("homeFurnishing");
			test.pass("homeFurnishing purchase successful");

			// Perform actions on Blanket & Quilts category
			test.log(Status.INFO, "Navigating to Furniture");
			furniture.navigateToHomeLinenFurniture();

			test.log(Status.INFO, "Navigating to Home Linen and Furniture");
			shoppingCategoriesPage.navigateToHomeLinenFurniture();

			shoppingCategoriesPage.clickOnBlanketsAndQuilts();
			takeScreenshot("Blanket & Quilts Page Open");
			test.pass("Blanket & Quilts Page Open successful");

			shoppingCategoriesPage.filterAndPurchaseBlanket();
			takeScreenshot("BlanketsAndQuilts");
			test.pass("Blanket purchase successful");

			// Perform actions on Furniture category
			test.log(Status.INFO, "Navigating to Furniture");
			furniture.navigateToHomeLinenFurniture();

			furniture.clickOnfurniture();
			takeScreenshot("Furniture Page Open");
			test.pass("Furniture Page Open successful");

			furniture.clickOnSofaandBeds();
			takeScreenshot("Sofa and Beds Page Open");
			test.pass("Sofa and Beds Page Open successful");

			furniture.clickOnBfurniture();
			takeScreenshot("Back to furniture Page");
			test.pass("Back to furniture Page successful");

			furniture.clickOnStorageCabinets();
			takeScreenshot("Storage Cabinets Page Open");
			test.pass("Storage Cabinets Page Open successful");

			furniture.filterAndPurchaseStorageCabinets();
			takeScreenshot("Furniture");
			test.pass("Furniture purchase successful");

			// Perform actions on Home and Wellness category
			test.log(Status.INFO, "Navigating to Home and Wellness");
			homeAndWellness.navigateToHomeLinenFurniture();

			homeAndWellness.clickOnHomeAndWellness();
			takeScreenshot("Home & Wellness Page Open");
			test.pass("Home and Wellness Page Open successful");

			homeAndWellness.filterAndPurchaseHomeAndWellness();
			takeScreenshot("HomeAndWellness");
			test.pass("Home and Wellness purchase successful");

			// Perform actions on Brands category
			test.log(Status.INFO, "Navigating to Brands");
			brands.navigateToHomeLinenFurniture();

			brands.clickOnBranded();
			takeScreenshot("Brand Page Open");
			test.pass("Branded Page Open successful");

			brands.filterAndPurchaseBranded();
			takeScreenshot("Brands");
			test.pass("Branded purchase successful");

			// Perform actions on Cart
			test.log(Status.INFO, "Navigating to SearchProduct");
			cart.navigateToCart();
			takeScreenshot("Cart Page Open");
			test.pass("Cart Page Open successful");

		} catch (Exception e) {
			test.fail("Test failed due to exception: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		extent.flush();
	}

	public void takeScreenshot(String fileName) {
		File imgDir = new File("E:\\SDET201\\NaaptolScreenShot\\");
		if (!imgDir.exists()) {
			imgDir.mkdirs(); // Create the directory
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File img = new File(imgDir, fileName + ".png");
		try {
			FileUtils.copyFile(image, img);
			test.addScreenCaptureFromPath(img.getAbsolutePath(), fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
