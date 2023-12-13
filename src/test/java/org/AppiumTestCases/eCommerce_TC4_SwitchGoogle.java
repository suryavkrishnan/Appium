package org.AppiumTestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.PageObject.CartPage;
import org.PageObject.FormPage;
import org.PageObject.ProductCatalogPage;
import org.appiumProject.TestUtils.AppiumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class eCommerce_TC4_SwitchGoogle extends AppiumBaseTest{
	@Test
	public void fillForm() throws MalformedURLException, InterruptedException
	{
		
		formPage.setNameField("SuryaKrishnan");
		formPage.setGender("female");
		//formPage.setCountry("Argentina");
		
		
		//Thread.sleep(2000);
		ProductCatalogPage productCatalog = formPage.submitForm();
		productCatalog.addItemTocartbyIndex(0);
		productCatalog.addItemTocartbyIndex(0);
		
		
		CartPage cartPage=productCatalog.openCart();
		Thread.sleep(2000);
		//WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		//cartPage.WaitForElementToAppear(ele, driver);
	    Double totSum=cartPage.getProductSum();
		Double displySum=cartPage.getTotalamoutDisplyed();
		Assert.assertEquals(totSum, displySum);
		cartPage.acceptTerms();
		cartPage.submitOrder();
		
		/*
			
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		*/
		
		Thread.sleep(2000);
		
		
	}

	

	
	
}
