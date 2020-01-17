package tests;



import java.net.URL;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Demo2 {

	AppiumDriver<MobileElement> driver;
	@BeforeTest
	public void setup() throws Exception {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability("deviceName", "Abhishek");
		dcap.setCapability("udid", "23aaa9a4");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("platformVersion", "9" );
		dcap.setCapability("appPackage", "com.miui.calculator");
		dcap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		dcap.setCapability("skipDeviceInitialization", true);
		dcap.setCapability("skipServerInitialization", true);
		dcap.setCapability("noReset", true);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, dcap);
//		System.out.println("Application started...");
	}
	
	@Test
	public void sampleTest() throws Exception {
//			MobileElement ver = driver.findElementById("");
			//MobileElement agree = driver.findElementById("android:id/button1");
			
//			if(agree != null) {
//				agree.click();
//				System.out.println("Hello Calculator...!!");
//				
//				
//			}
//			
			MobileElement two=driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		   two.click();
		  
		   driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
		   
		   
		   
		   MobileElement four=driver.findElementById("com.miui.calculator:id/btn_4_s");
		   four.click();
		   MobileElement equalTo=driver.findElementById("com.miui.calculator:id/btn_equal_s");
		   equalTo.click();
		   
		   MobileElement results=driver.findElementById("com.miui.calculator:id/result");
			
		String res = results.getText();
		System.out.println(res);
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("Hellooo");
	}
}
