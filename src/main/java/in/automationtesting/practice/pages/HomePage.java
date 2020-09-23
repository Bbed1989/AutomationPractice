package in.automationtesting.practice.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject2 {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='menu-item-40']")
	private WebElement shopButton;

	@FindBy(xpath = "//a[@rel='nofollow']")
	List<WebElement> activeButtons;

	@FindBy(xpath = "//img[@alt='Selenium Ruby']")
	WebElement seleniumRubyImage;

	@FindBy(xpath = "//a[@title='Automation Practice Site']")
	WebElement homeButton;

	private String pageUrl = "http://practice.automationtesting.in/";

	
	  public HomePage(WebDriver driver, Logger log) { 
		  super(driver, log);
		  PageFactory.initElements(driver, this);
	  }
	 

	/** Open Welcome Page with its Url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		// method from BasePageObject to get url
		openUrl(pageUrl);
		log.info("Page Opened.");
	}

	/** Open Shop page */
	public void clickShopButton() {
		waitForVisibility(shopButton);
		shopButton.click();
	}

	/** Open Home Page */
	public void clickHomeButton() {
		waitForVisibility(homeButton);
		homeButton.click();
	}

	/** Counting Actual arrivals on the Page */
	public int actualArrivalCount() {
		return activeButtons.size();
	}

	/** Printing Actual arrivals on the Page */
	public void printActualArrivalCount() {
		int actualArrivalCount = (activeButtons).size();
		log.info("Arrival Count: " + actualArrivalCount);
	}

	public void clickSeleniumRubyImage() {
		log.info("Clicking Selenium Ruby Image from Home page.");
		waitForVisibility(seleniumRubyImage);
		seleniumRubyImage.click();
	}

}
