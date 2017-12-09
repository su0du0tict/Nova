package Test_Package;
import org.testng.annotations.Test;
import java.util.List;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Web_APP {

public static WebDriver driver;	
@Test(dependsOnGroups="Rest_API",groups="Web_App")
public void test_init() throws Exception 
{
	// This is the init for the web application
	System.setProperty("webdriver.gecko.driver", "C:\\Custom Installations\\Appium\\Geckodriver\\geckodriver-v0.18.0-win64.exe");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("acceptInsecureCerts",true);
	driver = new FirefoxDriver(capabilities);
	driver = new FirefoxDriver(capabilities);
	driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get("https://wcportal-dev.azurewebsites.net/Login/Login?ReturnUrl=%2F");
	
	Thread.sleep(5000);
	//driver.quit();
}

@Test(dependsOnMethods="test_init",groups="Web_App")
public void login_portal() throws Exception
{
	
	WebElement UN=driver.findElement(By.id("Username"));
	WebElement PWD=driver.findElement(By.id("Password"));
	WebElement Login_Button=driver.findElement(By.xpath("html/body/div/div/form/div[2]/div[2]/input"));
	
}

@Test(dependsOnMethods="login_portal",groups="Web_App")
public void enter_values_for_login() throws Exception
{
	
	WebElement UN=driver.findElement(By.id("Username"));
	WebElement PWD=driver.findElement(By.id("Password"));
	WebElement Login_Button=driver.findElement(By.xpath("html/body/div/div/form/div[2]/div[2]/input"));
	UN.click();
	UN.clear();
	UN.sendKeys("v415945");
	
	
	
	PWD.click();
	PWD.clear();
	PWD.sendKeys("NovaPa$$1");
	
	Login_Button.click();
	Thread.sleep(5000);
	
}
@Test(dependsOnMethods="enter_values_for_login",groups="Web_App")
public void select_pickup_tab() throws Exception
{
	driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div[2]/div[2]/button[1]")).click();;
	Thread.sleep(10000);
}
@Test(dependsOnMethods="select_pickup_tab",groups="Web_App") 
public void row_column_exercise() throws Exception
{
	
	try {
	List < WebElement > rows_table = driver.findElements(By.tagName("tr"));	
	Thread.sleep(5000);
	int rows_count = rows_table.size();
	for (int row = 0; row< rows_count ; row++) 
	{
		   String Text=rows_table.get(row).getText();
		   
		   
		   if(Text.toLowerCase().contains( "NEW FROM TMS".toLowerCase() ))
		   {
			   System.out.println("Row # is " + row );
			   System.out.println("Value of Element is"+Text);
			   
			   System.out.println("I am inside the controversial loop of items");
			   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			   for(int j=0;j<Columns_row.size();j++)
			   {
				   System.out.println("Value of Index of Column    :"+j+"Text"+Columns_row.get(j).getText());
				   Columns_row.get(12).click();
				   
			   
			   
			   }
		   }
	
	}
	
	} catch (Exception e) {  System.out.println("Exception");}
	
	    

}



@Test(dependsOnMethods="row_column_exercise",groups="Web_App") 
public void push_to_app() throws Exception
{
	driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div/div[2]/div[1]/div/div/div[1]/p/button")).click();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("html/body/div[4]/div/div/div[4]/button[2]")).click();
	//driver.switchTo().alert().accept();
	
	WebElement element= driver.findElement(By.xpath("//button[contains(text(),'SEND')]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	action.moveToElement(element).click().perform();
}


}


