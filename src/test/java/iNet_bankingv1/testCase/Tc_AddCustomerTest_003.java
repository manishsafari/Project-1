package iNet_bankingv1.testCase;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;


import org.testng.annotations.Test;

import iNet_bankingv1.pageObject.AddCustomerPage;
import iNet_bankingv1.pageObject.LoginPage;

public class Tc_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(4000);
	
		try
		{
			driver.findElement(By.id("ad_iframe")).click();;
			}
		catch(Exception e)
		{
			System.out.println("advertisement is not visible");
		}
		
	
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
				addcust.clickAddNewCustomer();
		
				
		addcust.custName("manish");
		addcust.custgender("male");
		addcust.custdob("08", "03", "1995");
		Thread.sleep(3000);
		addcust.custaddress("murgesh pallya");
		addcust.custcity("benegluru");
		Thread.sleep(3000);
		addcust.custstate("karnataka");
		addcust.custpinno("600085");
		addcust.custtelephoneno("8787878789");
	
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
	
		addcust.custpassword("aghju");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!");
	if(res==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	
	public static String randomenum()
	{
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
	
}
