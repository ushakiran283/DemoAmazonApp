package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	SignInPage signinpage;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By accounts = By.xpath("//span[text()='Account & Lists']");
	private By signIn = By.xpath("//div[@id='nav-flyout-ya-signin']/a/span");
	private By amazontext = By.xpath("//span[@class='a-size-base a-color-base']");
	private By amazonBasicsHeader = By.xpath("//div[@class='a-cardui-header']//h2[text()='AmazonBasics']");

	public WebElement getAmazonBasicsHeader() {
		return driver.findElement(amazonBasicsHeader);
	}

	public WebElement getAmazontext() {
		return driver.findElement(amazontext);
	}

	public WebElement getaccounts() {
		return driver.findElement(accounts);
	}

	public SignInPage getSignIn() {
		driver.findElement(signIn).click();
		signinpage = new SignInPage(driver);
		return signinpage;

	}

}
