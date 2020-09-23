package in.automationtesting.practice.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject2 {
	protected WebDriver driver;
	protected Logger log;
	
	public BasePageObject2(WebDriver driver, Logger log) {
		this.driver=driver;
		this.log=log;
	}
	
	/** Open page with given URL */
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	/** Get the url of the current page from browser */
	// public because will be used in tests, not only in pages.
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	/** Get WebElement text*/
	public String getWebElemenText(WebElement webElement) {
		waitForVisibility(webElement);
		return webElement.getText();
	}
	
	
	//* Wait for visibility of WebElement on the page*/
	protected void waitForVisibility(WebElement element) throws Error{
          new WebDriverWait(driver, 30)
               .until(ExpectedConditions.visibilityOf(element));
   }
	

}
