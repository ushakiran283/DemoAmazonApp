package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageObjects.ItemsSearch;

public class SearchItemTest extends BaseSetup {

	ItemsSearch itemsearch;

	@Test
	public void ItemSearch() throws IOException {
		itemsearch = new ItemsSearch(driver);
		itemsearch.getSearchItem().sendKeys(prop.getProperty("searchitemtext"));
		List<WebElement> autotext = itemsearch.getSuggestion();
		for (WebElement text2 : autotext) {
			if (text2.getText().equalsIgnoreCase("65-inch smart tv")) {
				text2.click();
				break;
			}
		}
	}

}
