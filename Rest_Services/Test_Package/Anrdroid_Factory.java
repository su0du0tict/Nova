package Test_Package;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Anrdroid_Factory {
	
	public static DesiredCapabilities capabilities;
	public static WebDriver driver;
		
		public static DesiredCapabilities config_desired_capabilities(String deviceName,String platformVersion) throws Exception
		{
		capabilities= new DesiredCapabilities();
		//Set android deviceName desired capability to Android Emulator. 
		capabilities.setCapability("deviceName", deviceName);
		
		//Set BROWSER_NAME desired capability to Android. 
		capabilities.setCapability("browserName", "Android");
		//Set android VERSION from device desired capability. 
		capabilities.setCapability("platformVersion", platformVersion);
		// Set android platformName desired capability to Android. 
		capabilities.setCapability("platformName", "Android");
		// Set android appPackage desired capability.  
		capabilities.setCapability("appPackage", "com.abc.mcoe.dash.dev");
		// Set android appActivity desired capability.  
		capabilities.setCapability("appActivity", "com.abc.mcoe.dash.dev.DashDevActivity");
		//capabilities.setCapability("appActivity", "org.appecelator.titanium.TiActivity");
		//capabilities.setCapability("appActivity", "com.abc.mcoe.dash.dev.NotificationActivity");
		//capabilities.setCapability("appActivity", "com.crittercism.NotificationActivity");
		//Reset the application
		capabilities.setCapability("fastReset", true); 
		
		return capabilities;
		}
		
		public static WebDriver launch_App(String URL) throws Exception
		{
			driver = new AndroidDriver(new URL(URL),capabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			return driver;
		}

}
