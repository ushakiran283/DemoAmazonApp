package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsSearch {

	public WebDriver driver;

	public ItemsSearch(WebDriver driver) {
		this.driver = driver;
	}

	private By searchitem = By.cssSelector("#twotabsearchtextbox");
	private By searchicon = By.cssSelector("#nav-search-submit-button");
	private By suggestion = By.xpath("//div[@class='s-suggestion']");
	private By tvtext = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By itemlist = By.cssSelector("#add-to-wishlist-button-submit");
	private By createlist = By.xpath("//span[@class='a-button a-button-primary']");

	public WebElement getCreatelist() {
		return driver.findElement(createlist);
	}

	public WebElement getItemlist() {
		return driver.findElement(itemlist);
	}

	public List<WebElement> getSuggestion() {
		return driver.findElements(suggestion);
	}

	public List<WebElement> getTvtext() {
		return driver.findElements(tvtext);
	}

	public WebElement getSearchItem() {
		return driver.findElement(searchitem);
	}

	public WebElement getSearchIcon() {
		return driver.findElement(searchicon);
	}
}
