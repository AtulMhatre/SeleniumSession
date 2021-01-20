package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	
	WebDriver driver;
	
	public 	ProductSearchPage (WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//input[@placeholder='Search Products']")
	private WebElement textSearchProducts;
	
	@FindBy(xpath="//div[@class='w-full h-full flex flex-row items-center justify-between']")
	private WebElement searchBox;
	
	
	/**
	 * Enter value in search product text box
	 * @param text
	 */
	public void enterSearchProducts(String text) {
		searchBox.click();
		textSearchProducts.click();
		textSearchProducts.clear();
		textSearchProducts.sendKeys(text);
	}
	/**
	 * perform click on keyboard Enter key
	 */
	public void pressEnterButton() {
		textSearchProducts.sendKeys(Keys.ENTER);		
	}
	
	

}
