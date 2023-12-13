package org.appiumProject.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.PageObject.FormPage;
import org.Utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.android.options.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumBaseTest extends AppiumUtils {
	
	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	public FormPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException 
	{
				Properties prop=new Properties();
				FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\appiumProject\\resources\\data.properties"));
				prop.load(fis);

		//To run Appium server directly from Eclipse and without cmd prompt use following code
		        service=StartAppiumServer(prop.getProperty("ipAddress"),Integer.parseInt(prop.getProperty("port")));
			   //OR
		
				//service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Owner\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				//.withIPAddress("10.0.0.242").usingPort(4723).build();
				//service.start();
		        
		//Run Server first in cmd prompt and run below code
				UiAutomator2Options options=new UiAutomator2Options(); //used for android device
				options.setDeviceName(prop.getProperty("AndroidDeviceName")); // put device details
				
		//download emulator need chrome driver into system and givn that path as below
				//options.setChromedriverExecutable("C:\\softwares\\chrome-win64");
				
				//options.setApp("C:\\Users\\Owner\\eclipse-AppiumProject\\AppiumProject2\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
				
				
				//driver=new AndroidDriver(new URL("http://10.0.0.242:4723/"), options); // This port getting by running appium server
				//OR
				driver=new AndroidDriver(service.getUrl(), options); // This port getting by running appium server
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				formPage=new FormPage(driver);
		
		
	}
	

	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
