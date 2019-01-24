package com.qa.clare.PhpTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	// select2-input
	//

	@FindBy(tagName = "div")
	private List<WebElement> myList;

	@FindBy(id = "s2id_autogen8")
	private WebElement divForSearchBar;

	// METHOD FOR THE checkIn BAR AS A WARM UP THAT DOESNT WORK ://///
	public String checkIn(String date) {

		String anyString = "";
		for (WebElement element : myList) {
			try {

				element = element.findElement(By.tagName("input"));

				element.click();
				element.sendKeys("23/01/2019");

				anyString = element.getText();

				break;

			} catch (Exception e) {
			}

		}

		return anyString;

	}

	// METHOD FOR BEING ABLE TO BOOK

	public void Booking(String date1, String date2) {

		for (WebElement element : myList) {
			try {

				element = element.findElement(By.tagName("input"));

				element.click();
				element.sendKeys("23/01/2019");

				element.sendKeys(Keys.TAB);
				element.sendKeys("25/01/2019");
				
				element.sendKeys(Keys.TAB);
				element.click();

				break;

			} catch (Exception e) {
			}

		}

	

	}

}
