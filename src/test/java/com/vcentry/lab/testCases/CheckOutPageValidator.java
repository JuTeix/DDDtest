package com.vcentry.lab.testCases;

import java.io.File;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import com.vcentry.lab.initializer.Initializer;
import com.vcentry.lab.initializer.Locator;
import com.vcentry.lab.inputReader.InputReader;
import com.vcentry.lab.pages.CheckoutPage;
import com.vcentry.lab.pages.HomePage;
import com.vcentry.lab.pages.LoginPage;
import com.vcentry.lab.screencshotgenerator.ScreenshotGenerator;

public class CheckOutPageValidator extends Initializer {

	@BeforeTest
	public void setUp() throws IOException {
		//initialize(); // opens the browser
	}

	@Test(dataProvider = "CheckoutTest")
	                                      //0            1            2                    3                  4            5
	public void validateCheckoutPage(String testdata, String user, String password, String productname, String mobile, String mail,
			String prodcat, String productQty, String purchaser) throws IOException {
                  // 6              7              8
		initialize();
		log=reports.startTest("start "+testdata, "validate - "+testdata);	
		log.log(LogStatus.PASS,testdata+"- intialized");
		// initialize(); //opens the browser
		wd.get(envProp.getProperty("URL"));
		log.log(LogStatus.PASS,testdata+"- url completed successfully");
		
		/*
		 * step 1 wd.findElement(By.name("username")).sendKeys("Ju_teix");
		 * wd.findElement(By.name("password")).sendKeys("Praga2019");
		 * wd.findElement(By.name("password")).submit();
		 */

		/*
		 * //step2 wd.findElement(By.name(LocatorProp.getProperty(
		 * "LOGINPAGE_TYPE_USERNAME_NAME"))).sendKeys("Ju_teix");
		 * wd.findElement(By.name(LocatorProp.getProperty(
		 * "LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys("Praga2019");
		 * wd.findElement(By.name(LocatorProp.getProperty(
		 * "LOGINPAGE_TYPE_PASSWORD_NAME"))).submit();
		 */

		/*
		 * // step3
		 * Locator.getElementByName("LOGINPAGE_TYPE_USERNAME_NAME22i3kj3nc").
		 * sendKeys("Ju_teix");
		 * Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys(
		 * "Praga2019");
		 * Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();
		 */

		// Step 4 - page object - readable, reusable, maintainable

		LoginPage.enterUsername(user);// 1
		LoginPage.enterPassword(password);
		LoginPage.clickLogin();
		log.log(LogStatus.PASS,testdata+"- login page completed successfully");
		
		wd.get(envProp.getProperty("LAB_URL"));
		HomePage.clickFrameworkForm();
		HomePage.clickSimpleForm();
		log.log(LogStatus.PASS,testdata+"- home page completed successfully");
		
		CheckoutPage.enterProductName(productname);// 2
		CheckoutPage.enterMobile(mobile);// 3
		CheckoutPage.enterEmail(mail);// 4
		CheckoutPage.selectProdCat(prodcat);// 5
		CheckoutPage.enterProductQty(productQty);// 6
		CheckoutPage.enterPurchaserName(purchaser);// 7
		CheckoutPage.clickGst();
		CheckoutPage.clickCOD();
		CheckoutPage.clickPlaceOrder();
		log.log(LogStatus.PASS,testdata+"- checkout page completed successfully");
		
	}

	@DataProvider(name = "CheckoutTest")
	public static Object[][] getData() throws IOException {
		
		if(InputReader.verifyRunMode("CheckOutPageValidator")){
		Object[][] data=InputReader.verifyMultiData("CheckOutPageValidator");
		
		
		return data;
		}
		return null;

	}

	@AfterMethod
	public void tearDown(ITestResult r) throws IOException {
		// logout
		ScreenshotGenerator.generateScreenshot(r);
		HomePage.clickLogout();
		
	}
	
}