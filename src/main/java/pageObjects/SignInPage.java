package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;
	ItemsSearch itemsearch;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.cssSelector("#ap_email");
	By continuebtn = By.xpath("//div//span[@id='continue']");
	By password = By.cssSelector("#ap_password");
	By signInbtn = By.cssSelector("#signInSubmit");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getContinuebtn() {
		return driver.findElement(continuebtn);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSignInbtn() {
		return driver.findElement(signInbtn);
	}

}
