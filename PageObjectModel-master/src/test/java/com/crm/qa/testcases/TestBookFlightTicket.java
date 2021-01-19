package com.crm.qa.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ConfirmationPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.PurchasePage;
import com.crm.qa.pages.ReservePage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverUtils;
public class TestBookFlightTicket  {
	public WebDriver driver;
	TestBase testBase;
	String filePath = "login";
	String elementName = "testData";
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initialization();
		driver = utils.getDriver();
		testBase = new TestBase(driver);
		}
	
	/*
	 * test method
	 */
	@Test
	public void verifyTicketBooking()  {
		
	Map<String,String> testData = TestUtil.getTestData("testData.json", "verifyTicketBooking");
	HomePage homePage = testBase.getHomePage();
	
	ReservePage reservePage = homePage.selectDepartureCity(testData.get("departureCity"))
									  .selectDestinationCity(testData.get("destinationCity"))
									  .clickOnFindFights();
	
	PurchasePage purchasePage = reservePage.clickChooseThisFlight();
	
	ConfirmationPage confirmationPage = purchasePage.enterName(testData.get("name"))
													.enterAddress(testData.get("address"))
													.enterCity(testData.get("city"))
													.enterState(testData.get("state"))
													.enterZipCode(testData.get("zipCode"))
													.selectCardType(testData.get("cardType"))
													.enterCreditCardNumber(testData.get("creditCardNumber"))
													.enterMonth(testData.get("month"))
													.enterYear(testData.get("year"))
													.enterNameOnCard(testData.get("nameOnTheCard"))
													.clickPurchaseFlight();
	
	Assert.assertEquals(confirmationPage.getStatus(), "PendingCapture");
		
	}

	
	@AfterMethod
	public void quite() {
		driver.close();
	 }
	}

