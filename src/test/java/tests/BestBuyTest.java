package tests;

import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BestBuyTest {
	
	AppiumDriver<MobileElement> driver;
	@BeforeTest
	public void setup() throws Exception {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability("deviceName", "Abhishek");
		dcap.setCapability("udid", "23aaa9a4");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("platformVersion", "9" );
		dcap.setCapability("appPackage", "com.bestbuy.android");
		dcap.setCapability("appActivity", "com.bestbuy.android.activity.HomeScreen");
		dcap.setCapability("skipDeviceInitialization", true);
		dcap.setCapability("skipServerInitialization", true);
		dcap.setCapability("noReset", true);
		dcap.setCapability("chromedriverExecutable", "C:\\Users\\mabhishek\\Downloads\\chromedriver");
//		dcap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		dcap.setCapability("autoGrantPermissions", true);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, dcap);
		
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void launch(){
		
		MobileElement perm_allow = driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		
		if( perm_allow.isDisplayed()) {
		
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			System.out.println("found");
		}
	
		else {
			System.out.println("not found");
		}
		
		
		
	}
	
	@Test(priority=2)
	public void tapProduct() {
		if(driver.findElementById("com.bestbuy.android:id/Products").isDisplayed()) {
			driver.findElementById("com.bestbuy.android:id/Products").click();
			System.out.println("product page found");
		}
		
		else {
			System.out.println("Element not found");
		}
		
		Dimension dim = driver.manage().window().getSize();
		System.out.println(dim);
		
	}
	
	@Test(priority=3)
	public void tapAccount() {
		if(driver.findElementById("com.bestbuy.android:id/Account") != null) {
			driver.findElementById("com.bestbuy.android:id/Account").click();
//			MobileElement Panel = driver.findElementById("com.bestbuy.android:id/main_view_pager\r\n" + 
//					"");
//			SwipeScreen(Panel, driver);
			String ret = getWebViewText();
			System.out.println(ret);
		}
		
		else {
			System.out.println("Element not found!!");
		}
	}
	
	
	public String getWebViewText()
	{
		System.out.println("First Current Context : "+driver.getContext());
		driver.findElementByXPath("//android.widget.TextView[@text=\"Gift Cards\"]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElementByXPath("//android.view.View[@text=\"United States United States\"]").click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text=\"E-Gift Cards E-Gift Cards* Emailed, digital cards. Perfect for when you are short on time.\"]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		

		
		// Using this method we switch to web view
		switchContext("WEBVIEW");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("recipientName-input").sendKeys("Abhishek");
		String webViewText = driver.findElementById("recipientName-input").getText();
		return webViewText;
		
	}
	
	public void switchContext(String context)
	{
		System.out.println("Before Switching : "+driver.getContext());
		Set<String> con = driver.getContextHandles();
		for(String c : con)
		{
			System.out.println("Available Context : "+c);
			if(c.contains(context))
			{
				driver.context(c);
				break;
			}
		}
		System.out.println("After Switching : "+driver.getContext());
	}
	
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
	
	
	
	
}
