package tests;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class FlipkartTest {
	
	AppiumDriver<MobileElement> driver;
	@BeforeTest
	public void setup() throws Exception {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability("deviceName", "Abhishek");
		dcap.setCapability("udid", "23aaa9a4");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("platformVersion", "9" );
		dcap.setCapability("appPackage", "com.flipkart.android");
		dcap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		dcap.setCapability("skipDeviceInitialization", true);
		dcap.setCapability("skipServerInitialization", true);
		dcap.setCapability("noReset", true);
		dcap.setCapability("autoGrantPermissions", true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, dcap);
	
	}
	
	@Test
	public void Login() {
		
		//Tap drawer icon
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open Drawer\"]").click();
		MobileElement Panel = driver.findElementById("com.flipkart.android:id/flyout_recycler_view");
		SwipeScreen(Panel, driver);
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[9]/android.widget.LinearLayout[5]\r\n" + 
				"").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementById("com.google.android.gms:id/cancel").click();
		
		driver.findElementById("com.flipkart.android:id/tv_right_cta").click();
		
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Email ID\"]").sendKeys("abhiflip.22@gmail.com");
		
		driver.findElementById("com.flipkart.android:id/button").click();
		
		driver.findElementById("com.flipkart.android:id/phone_input").sendKeys("abhi22397");
		
		driver.findElementById("com.flipkart.android:id/button").click();
		
		
		
		//press cancel in dialog box
//		if(driver.findElementById("com.google.android.gms:id/cancel") != null) {
//			driver.findElementById("com.google.android.gms:id/cancel").click();
//		}
	
		
		
	}
	
	@Test
	public void SwipeScreen(MobileElement el, AppiumDriver<MobileElement> driver ) {
		MobileElement Panel = el;
		Dimension dimension = Panel.getSize();
		int Anchor = Panel.getSize().getHeight()/2;
		Double ScreenWidthStart = dimension.getWidth() * 0.8;
		int scrollStart = ScreenWidthStart.intValue();
		Double ScreenWidthEnd = dimension.getWidth() * 0.2;
		int scrollEnd = ScreenWidthEnd.intValue();
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform(); 
	}
//	@Test
//	public void enterCred() {
//		//press Use Email-ID
//		driver.findElementById("com.flipkart.android:id/tv_right_cta").click();
//		
//		//enter credentials
//		driver.findElementById("com.flipkart.android:id/phone_input").sendKeys("abhiflip.22@gmail.com");
//	}
	
}
