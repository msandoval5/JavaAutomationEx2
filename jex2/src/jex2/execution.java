package jex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class execution extends setUp 
{
	
	 public static void main(String[] args) {
		 setUp test = new setUp();
         test.Fill("Mariana");
         test.FillLastName("Sandoval");
         test.FillMobile("123");
         test.FillPass("123456");
         test.SelectMonth();
         test.SelectDay();
         test.SelectYear();
         test.CheckFemale();
         test.VerifyText();
         test.VerifyTitle();
         test.DriverTitle();
         test.EnterEmail();
         test.closeMethod();
	
	 }
	
}


/*A. Create the following flow.

Go to facebook.com.
Validate that URL is correct.
Validate the Title of the page, should be : Facebook - Log In or Sign Up.
Fill all Sign Up section (do not click on Sign Up button).
Choose a different Birthday not the default one.
Click on Female.
Validate following text is present:
Connect with friends and the
world around you on Facebook.
Click on Forgot Account?
Validate following text is displayed: “Find Your Account”.
Enter a valid email but non existing one and click on search.
Validate Error message is displayed (No search Results).
Things to consider:

Implement explicit waits for all the elements.
Separate the console app project in two, set up class and execution class.
Use A property to obtain Web title and assert to validate it.
User a property to obtain the URL and assert to validate it. */