package Test_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;



public class Mobile_Login {

	static String deviceName="07160795b61b1a04";
	static String platformVersion="6.0.1";
	static String URL="http://127.0.0.1:4723/wd/hub";
	static DesiredCapabilities capabilities;
	static WebDriver driver;

	static String Nova_UN="v415945";
	static String PWD="NovaPa$$1";
@Test(dependsOnGroups="Web_App")
public void init() throws Exception
{
 capabilities=Anrdroid_Factory.config_desired_capabilities(deviceName,platformVersion);
 driver=Anrdroid_Factory.launch_App(URL);
}


@Test(dependsOnGroups="Web_App",dependsOnMethods="init")
public void login() throws Exception
{
	//@FindBy(how=How.XPATH,using=("//android.widget.Button[@text='Accept']")) WebElement Accept;
	Thread.sleep(5000);
	List<WebElement> Edit_Text = driver.findElements(By.className("android.widget.EditText"));
	int Elementcount=Edit_Text.size();
	System.out.println(Elementcount);
	Edit_Text.get(0).click();
	Edit_Text.get(0).clear();
	Edit_Text.get(0).sendKeys(Nova_UN);;// Enter Username
	
	Edit_Text.get(1).click();
	Edit_Text.get(1).clear();
	Edit_Text.get(1).sendKeys(PWD);// Enter Password
	
	driver.findElement(By.xpath("//android.widget.Button[@text='Log In']")).click();;
	
	
	
	

}


@Test(dependsOnGroups="Web_App",dependsOnMethods="login")
public void cancel_popup()
{
	try {

		driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();;
	
	} catch (Exception e) {System.out.println("Password Notice was not found ");} 
}

@Test(dependsOnGroups="Web_App",dependsOnMethods="cancel_popup")
public void TnC_Agree()
{
	WebElement Agree;
	try {
		Thread.sleep(15000);
		Agree=driver.findElement(By.xpath("//android.widget.Button[@text='Agree']"));
		WebDriver driver_touch=driver;
		TouchAction location=new TouchAction((MobileDriver) driver_touch);
		//location.tap(Agree);
		Agree.click();
		
	} catch (Exception e) {System.out.println("TnC Notice could not be clicked");} 
}


@Test(dependsOnGroups="Web_App",dependsOnMethods="TnC_Agree")
public void Provide_permissions() throws Exception
{
	WebElement Enable_Camera=driver.findElement(By.xpath("//android.widget.Button[@text='Enable Camera']"));
	WebElement Enable_Storage=driver.findElement(By.xpath("//android.widget.Button[@text='Enable Storage']"));
	WebElement Enable_Location=driver.findElement(By.xpath("//android.widget.Button[@text='Enable Location']"));
	WebElement Next=driver.findElement(By.xpath("//android.widget.Button[@text='Next']"));
	
	//CodeBlock to Enable Camera!
	Enable_Camera.click();
	Thread.sleep(5000);
	List<WebElement> Elements_Camera_access=driver.findElements(By.className("android.widget.Button"));
	int count=Elements_Camera_access.size();
	Elements_Camera_access.get(1).click();
	Thread.sleep(5000);
	Elements_Camera_access.get(1).click();
	Thread.sleep(5000);
	
	
	
	/*for(int i=0;i<count;i++)
	{
		if((Elements_Camera_access.get(i).getText()).contains("Allow"));
		{
		System.out.println(Elements_Camera_access.get(i).getText());
		Elements_Camera_access.get(i).click();
		}
	}*/
	
	Thread.sleep(5000);
	//Code Block to Enable Storage:
	Enable_Storage.click();
	Thread.sleep(5000);
	//Code Block to Enable Notofications:
	
	Enable_Location.click();
	
	Thread.sleep(5000);
	Elements_Camera_access.get(1).click();
	Thread.sleep(5000);
	
	Next.click();
	
	
}


@Test(dependsOnGroups="Web_App",dependsOnMethods="Provide_permissions")
public void Open_Activity_and_Accept() throws Exception
{
	
	Thread.sleep(10000);
	List<WebElement> New_Activity_Notification=driver.findElements(By.className("android.widget.TextView"));
	int WebElement_index=New_Activity_Notification.size();
		
		New_Activity_Notification.get(7).click();
		
		for(int i=0;i<3;i++)
		{
		WebElement Next=driver.findElement(By.xpath("//android.widget.TextView[@text='Next']"));
		Next.click();
		Thread.sleep(5000);
		}
	
	List<WebElement> Accept_Reject_Activity=driver.findElements(By.className("android.widget.Button"));	
	int index=Accept_Reject_Activity.size();
	for (int i=0;i<index;i++)
	{
		System.out.println("Text :"+Accept_Reject_Activity.get(i).getText()+Integer.toString(i));
	}
	Accept_Reject_Activity.get(0).click();
	
}


@Test(dependsOnGroups="Web_App",dependsOnMethods="Open_Activity_and_Accept")
public void complete_activity_selection() throws Exception
{
	Thread.sleep(10000);
	List<WebElement> Pickup_Activity=driver.findElements(By.className("android.widget.ImageView"));
	int WebElement_index=Pickup_Activity.size();
		for (int i=0;i<WebElement_index;i++)
		{
			System.out.println("Text :"+Pickup_Activity.get(i).getText()+Integer.toString(i));
		}
		
		Pickup_Activity.get(9).click();
		
}


@Test(dependsOnMethods="complete_activity_selection")
public void complete_activity() throws Exception
{
	/* Module to Start Activity
	WebElement Start_Activity=driver.findElement(By.xpath("//android.widget.TextView[@text='Start']"));
	List<WebElement> Start_Activity_Image=driver.findElements(By.className("android.widget.ImageView"));
	Start_Activity_Image.get(7).click();
	Start_Activity_Image.get(8).click();
	Start_Activity.click();
	*/
	
	Thread.sleep(5000);
	List<WebElement> Confirm=driver.findElements(By.className("android.widget.ImageView"));
	System.out.println("Number of Image elements in the page are"+Confirm.size() );
	
	Confirm.get(11).click();
	Confirm.get(12).click();
	Confirm.get(13).click();
	Confirm.get(14).click();
	Confirm.get(15).click();
	Confirm.get(16).click();	
	
	
	
	
	MobileDriver driver_touch=(MobileDriver)driver;
	//Code to scroll to the end
	Dimension dimensions = driver_touch.manage().window().getSize();
	Double screenHeightStart = dimensions.getHeight() * 0.5;
	int scrollStart = screenHeightStart.intValue();
	System.out.println("s="+scrollStart);
	Double screenHeightEnd = dimensions.getHeight() * 0.2;
	int scrollEnd = screenHeightEnd.intValue();
	driver_touch.swipe(0,scrollStart,0,scrollEnd,2000);
	Thread.sleep(10000);
	
	WebElement Signature=driver.findElement(By.xpath("//android.widget.EditText[@text='Signatory (full name)']"));
	Signature.click();
	Signature.clear();
	Signature.sendKeys("Automation Test");
	
	Thread.sleep(5000);
	//[389,312][1050,394]
	TouchAction location=new TouchAction((MobileDriver) driver_touch);
	location.tap(500, 350).perform();
	
	
	
	WebElement Proof=driver.findElement(By.xpath("//android.widget.TextView[@text='TAKE A PROOF OF PICKUP PHOTO']"));
	Proof.click();
	
	Thread.sleep(5000);
	//Camera cordinates	[570,2178][871,2479]	
	TouchAction location1=new TouchAction((MobileDriver) driver);
	location1.tap(700,2300).perform();
	
	
	Thread.sleep(5000);
	// Ok Cordinates:[720,0][1440,196]
	TouchAction location2=new TouchAction((MobileDriver) driver);
	location2.tap(1000,100).perform();
	
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.Button[@text='SAVE']")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.Button[@text='Complete Activity']")).click();
	
	
	
	
	
	
}
}
