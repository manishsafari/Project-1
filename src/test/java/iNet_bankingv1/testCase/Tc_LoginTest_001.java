package iNet_bankingv1.testCase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.testng.annotations.Test;

import iNet_bankingv1.pageObject.LoginPage;
public class Tc_LoginTest_001 extends BaseClass{
	
	
	public static Logger log=LogManager.getLogger(Tc_LoginTest_001.class.getName());
	
	
@Test
public void loginTest() throws IOException
{
	driver.get(baseURL);
log.info("Driver is initialized");
	
	LoginPage lp= new LoginPage(driver);
	lp.setUserName(username);
	log.info("pass the username");
	//I DID PASSWORD WRONG ; should be - ;
	captureScreen(driver, "loginTest");
	lp.setPassword(password);
	
	
	System.out.println(driver.getTitle());
	log.info("successfully validate text message");

	lp.clickSubmit();

	 
}
}
