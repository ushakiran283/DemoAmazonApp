package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.ItemsSearch;
import pageObjects.LandingPage;
import pageObjects.SignInPage;

@Listeners(ListenersTestNG.class)
public class LandingPageTest extends BaseSetup {
	public WebDriver driver;
	LandingPage landing;
	Actions action;
	SignInPage signinpage;

	@BeforeClass
	public void InitialSetup() throws IOException {
		driver = initializeDriver();
	}

	@Test(priority = 0)
	public void Verifytext() throws InterruptedException {
		landing = new LandingPage(driver);
		WebElement text = landing.getAmazontext();
		Assert.assertEquals(text.getText(),
				"You are on amazon.com. You can also shop on Amazon India for millions of products with fast local delivery.");
	}

	@Test(priority = 1)
	public void SignIn() throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(landing.getaccounts()).perform();
		SignInPage signinpage = landing.getSignIn();
		Thread.sleep(2000);
		signinpage.getEmail().sendKeys(prop.getProperty("username"));
		signinpage.getContinuebtn().click();
		signinpage.getPassword().sendKeys(prop.getProperty("password"));
		signinpage.getSignInbtn().click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void ItemSearch() throws IOException, InterruptedException {
		ItemsSearch itemsearch = new ItemsSearch(driver);
		itemsearch.getSearchItem().sendKeys(prop.getProperty("searchitemtext"));
		List<WebElement> autotext = itemsearch.getSuggestion();
		for (WebElement text2 : autotext) {
			if (text2.getText().equalsIgnoreCase("65-inch smart tv")) {
				text2.click();
				break;
			}
		}
		List<WebElement> tv = itemsearch.getTvtext();
		for (WebElement tvtext1 : tv) {
			String text = tvtext1.getText().split(" ")[1];
			if (text.equalsIgnoreCase("65-inch")) {
				tvtext1.click();
				break;
			}
		}
		Assert.assertTrue(driver.findElement(By.cssSelector("#productTitle")).getText().contains("SAMSUNG 65-inch"));
		itemsearch.getItemlist().click();
		itemsearch.getCreatelist().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
