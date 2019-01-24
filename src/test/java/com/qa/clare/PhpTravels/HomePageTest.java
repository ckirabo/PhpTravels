package com.qa.clare.PhpTravels;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest {

	
	public static ExtentReports report;
	public static ExtentTest test;
	
	WebDriver driver;
	String url = "https://www.phptravels.net/en";

	
	@BeforeClass
	public static void reportingStartUp() {
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedTesting\\Reporting/reporting.html", false);
	}

	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",
    			"C:\\\\Users\\\\Admin\\\\Downloads/chromedriver_win32/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
	}
	

	@Test
	@Ignore
	public void testCheckIn() throws InterruptedException {
		//Test
		test = report.startTest("Verify checkIn Input");
		
		test.log(LogStatus.INFO, "Browser Started");		
		
		driver.get(url);
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		
	
		
		if(page.checkIn("23/01/2019").equals("23/01/2019")) {
			test.log(LogStatus.PASS,"Verify the check in is 23/01/2019 ");
		}
		else {
			test.log(LogStatus.FAIL,"Verify the check in is 23/01/2019 ");
		}
		
		
		
		Thread.sleep(3000);
		
	    assertEquals("Location entered doesnt match","London", page.checkIn("23/01/2019"));
	}

	@Test
	public void testBookingWorks() {
		//test = report.startTest("Verify Booking Works");
		
		//test.log(LogStatus.INFO, "Browser Started");

		driver.get(url);
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		
		page.Booking("23/01/2019","23/01/2019");
		
		
		
	}
	
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void reportingTearDown() {
		report.endTest(test);
		report.flush();
	}
	
	
}
