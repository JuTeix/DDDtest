package com.vcentry.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.vcentry.lab.initializer.Locator;

public class CheckoutPage {
	
	public static void enterProductName(String data){
		Locator.getElementById("CHECKOUTPAGE_TYPE_PRODUCT_ID").sendKeys(data);
	}
	public static void enterMobile(String data){
		Locator.getElementById("CHECKOUTPAGE_TYPE_MOBILE_ID").sendKeys(data);
	}
		public static void enterEmail(String data){
			Locator.getElementById("CHECKOUTPAGE_TYPE_EMAIL_ID").sendKeys(data);
	}
		public static void selectProdCat(String data){
			WebElement element = Locator.getElementById("CHECKOUTPAGE_SELECT_PRODCAT_ID");
			Select s = new Select(element);
			s.selectByVisibleText(data);	
			
		}
		public static void enterProductQty(String data) {
			Locator.getElementById("CHECKOUTPAGE_TYPE_PRODQTY_ID").sendKeys(data);
			
			}
		public static void enterPurchaserName(String data){
				Locator.getElementById("CHECKOUTPAGE_TYPE_PURCHASER_ID").sendKeys(data);		
			}
	
		public static void clickGst() {
				Locator.getElementById("CHECKOUTPAGE_CLICK_GST_ID").click();
			}

			public static void clickCOD() {
				Locator.getElementById("CHECKOUTPAGE_CLICK_COD_ID").click();
			}

			public static void clickPlaceOrder() {
				Locator.getElementById("CHECKOUTPAGE_CLICK_ORDER_ID").click();
			}

}	
