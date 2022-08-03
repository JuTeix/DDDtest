package com.vcentry.lab.pages;

import com.vcentry.lab.initializer.Initializer;
import com.vcentry.lab.initializer.Locator;

public class LoginPage extends Initializer {
	// username - type, password - type, login - click, signup - click

	public static void enterUsername(String data) {
		Locator.getElementByName("LOGINPAGE_TYPE_USERNAME_NAME").sendKeys(data);
	}

	public static void enterPassword(String data) {
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys(data);
	}

	public static void clickLogin() {
		Locator.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();

	}

	public static void clickSignUp() {
		Locator.getElementByLinkText("LOGINPAGE_CLICK_SIGNUP_LINKTEXT").click();
	}
}