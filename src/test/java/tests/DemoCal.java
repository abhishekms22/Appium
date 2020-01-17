package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DemoCal {
	
	static AppiumDriver<MobileElement> driver;
	@Test
	public static void main(String[] args) {
		try {
			openCal();
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			//e.printStackTrace();
		}
	}
	@BeforeTest
	public static void openCal() throws Exception {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability("deviceName", "Abhishek");
		dcap.setCapability("udid", "23aaa9a4");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("platformVersion", "9" );
		dcap.setCapability("appPackage", "com.miui.calculator");
		dcap.setCapability("appActivity", "com.miui,calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, dcap);
		System.out.println("Application started...");
	}
	@AfterTest
	public static void printmsg() {
		System.out.println("Success");
	}

}
