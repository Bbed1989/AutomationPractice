package in.automationtesting.practice.homepagetests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import in.automationtesting.practice.base.TestUtilities;
import in.automationtesting.practice.pages.HomePage;
import in.automationtesting.practice.pages.SeleniumRubyProductPage;

public class HomePageTests extends TestUtilities {

	@Test(enabled = false)
	public void arrivalCountTest() {

		log.info("Starting arrivalCountTest test");

//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();

//		3) Click on Shop Menu
		homePage.clickShopButton();
		
//		4) Now click on Home menu button
		homePage.clickHomeButton();
		
//		5) Test whether the Home page has Three Sliders only
		int expectedArrivalCount = 3;
		
//		6) The Home page must contains only three sliders
		log.info("Actual arrival Count is: " + homePage.actualArrivalCount());
		Assert.assertEquals(homePage.actualArrivalCount(), expectedArrivalCount,
				"Actual arrival Count is: " + homePage.actualArrivalCount() + ", But should be 3");

	}

	@Test(enabled = false)
	public void imageInArrivalNavigateTest() {
		log.info("Starting imageInArrivalNavigateTest test");
		SoftAssert softAssert = new SoftAssert();

//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();

//		3) Now click the image in the Arrivals
		homePage.clickSeleniumRubyImage();
		SeleniumRubyProductPage seleniumRubyPage = new SeleniumRubyProductPage(driver, log);

//		8) Test whether it is navigating to next page where the user can add that book into his basket.
		String expectedURL = "http://practice.automationtesting.in/product/selenium-ruby/";
		String actualURL = seleniumRubyPage.getCurrentURL();

//		9) Image should be clickable and should navigate to next page where user can add that book to his basket
		softAssert.assertEquals(actualURL, expectedURL, "Actual Url is not as expetced, it is: " + actualURL);
		softAssert.assertTrue(seleniumRubyPage.addToBasketButtonDisplayed());
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void arrivalDescriptionTest() {
		log.info("Starting arrivalDescriptionTest test");
//		1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();

//	3) Now click the image in the Arrivals
		homePage.clickSeleniumRubyImage();

//	4) Click on Description tab for the book you clicked on.
		SeleniumRubyProductPage seleniumRubyPage = new SeleniumRubyProductPage(driver, log);

//	5) There should be a description regarding that book the user clicked on
		String actualDescriptionText = seleniumRubyPage.getWebElemenText(seleniumRubyPage.descriptionText);
		log.info("Actual Description is: " + actualDescriptionText);
		Assert.assertTrue(actualDescriptionText.contains("The Selenium WebDriver Recipes book"));
	}

	@Test(enabled = false)
	public void arrivalReviewTest() {
		log.info("Starting arrivalReviewTest test");
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();

//	3) Now click the image in the Arrivals
		homePage.clickSeleniumRubyImage();

//	4) Now click on Reviews tab for the book you clicked on.
		SeleniumRubyProductPage seleniumRubyPage = new SeleniumRubyProductPage(driver, log);
		seleniumRubyPage.clickReviewTab();
		String actualReviewText = seleniumRubyPage.getWebElemenText(seleniumRubyPage.reviewText);
		log.info("Actual Review text is: " + actualReviewText);
		
//	5) There should be a Reviews regarding that book the user clicked on
		Assert.assertTrue(actualReviewText.contains("Reviews"));
	}
	/*
	 
	 * 
	 * // 14) Click on the Add To Basket button which adds that book to your basket
	 * rubyObj.clickAddToBasketButton2();
	 * 
	 * // 15) User can view that Book in the Menu item with price.
	 * softAssert.assertTrue(rubyObj.itemInBasket.getText().contains("500.00"));
	 * System.out.println("Cart displays: " + rubyObj.itemInBasket.getText());
	 */
}
