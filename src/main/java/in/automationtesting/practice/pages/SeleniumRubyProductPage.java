package in.automationtesting.practice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumRubyProductPage extends BasePageObject2 {
	WebDriver driver;
	@FindBy(xpath = "//button[text()='Add to basket']")
	WebElement addToBasketButton;
	
	@FindBy(xpath = "//div[@id='tab-description']//p")
	public WebElement descriptionText;
	
	@FindBy(xpath = "//a[@href='#tab-reviews']")
	public WebElement reviewTab;
	
	@FindBy(xpath = "//div[@id='comments']/h2[@class='woocommerce-Reviews-title']")
	public WebElement reviewText;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement addToBasketButton2;
	
	@FindBy(xpath = "//*[@id=\"wpmenucartli\"]/a")
	public WebElement itemInBasket;
	
	public SeleniumRubyProductPage(WebDriver driver, Logger log) {
		super(driver, log);
		PageFactory.initElements(driver, this);
	}
	
	/** Check if Add to Basket button is displayed*/
	public boolean addToBasketButtonDisplayed() {
		waitForVisibility(addToBasketButton);
		log.info("addToBasketButton is displayed.");
		return addToBasketButton.isDisplayed();
	}
	

	/** Swithing to the review tab*/
	public void clickReviewTab() {
		waitForVisibility(reviewTab);
		reviewTab.click();
	}
	
	public void clickAddToBasketButton2() {
		addToBasketButton2.click();
	}

}
