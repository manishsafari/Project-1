package iNet_bankingv1.testCase;

import java.io.IOException;


import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import iNet_bankingv1.pageObject.LoginPage;
import iNet_bankingv1.utilities.XLUtils;

public class Tc_LoginDDT_002 extends BaseClass
{
@Test(dataProvider="LoginData")
public void loginDDT(String user,String pwd) throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(user);
	lp.setPassword(pwd);
	lp.clickSubmit();
	Thread.sleep(3000);
	 
	
if(isAlertPresent()==true)
{
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
	Assert.assertTrue(false);
}
else
{
	Assert.assertTrue(true);
	lp.clickLogout();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
driver.switchTo().defaultContent();
}
	
	
	
	
}
// user defined method created to check alert is present or not

public boolean isAlertPresent()
{
	try
	{

	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
}


@DataProvider(name="LoginData")
String[][] getData() throws IOException
{

	String path=System.getProperty("user.dir")+"/src/test/java/iNet_bankingv1/testData/LoginData.xlsx";
//D:\Automation\iNet_bankingv1\src\test\java\iNet_bankingv1\testData\LoginData.xlsx
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	int colcount=XLUtils.getCellCount(path, "Sheet1",1);

String logindata[][]=new String[rownum][colcount];

for(int i=1;i<=rownum;i++)
{
	for(int j=0;j<colcount;j++)
	{
		logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
	}
}
return logindata;
}
}
