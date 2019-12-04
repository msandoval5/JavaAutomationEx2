package jex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;


public class setUp {
	
	WebDriver driver;
	WebDriverWait wait =new WebDriverWait(driver, 20);

	//Web Elements
	WebElement title = driver.findElement(By.name("firstname"));
	WebElement firstName = driver.findElement(By.name("firstname"));
	WebElement lastName = driver.findElement(By.name("lastname"));
	WebElement mobileTextbox = driver.findElement(By.name("reg_email__"));
	WebElement Pass = driver.findElement(By.name("reg_passwd__"));
	WebElement Month = driver.findElement(By.id("month"));
	WebElement Day = driver.findElement(By.id("day"));
	WebElement Year = driver.findElement(By.id("year"));
	WebElement FemaleCheckBox = driver.findElement(By.name("u_0_9"));
	WebElement titleText = driver.findElement(By.xpath("//span[contains(text(),\"cuenta\")]"));
	WebElement textDisplayed = driver.findElement(By.className("_5iyx"));
	WebElement femaleCheckBox = driver.findElement(By.id("u_0_9"));
	WebElement mailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
	WebElement signUp = driver.findElement(By.name("websubmit"));
	WebElement mailErrorMessage = driver.findElement(By.id("reg_error_inner"));
	
	
	public void setUpMethod() {
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.manage().window().maximize();
		String baseUrl = "https://www.facebook.com/";
	    driver.get(baseUrl);
	}
	public void closeMethod() {
		driver.quit();
	}
    public void Fill(String name)
    {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.sendKeys(name);
      
    }
    public void FillLastName(String lastname)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(lastName));
       
        lastName.sendKeys(lastname);
    }
    public void FillMobile(String mobile)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(mobileTextbox));
        mobileTextbox.sendKeys(mobile);
    }
    public void FillPass(String Password)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(Pass));
        Pass.sendKeys(Password);
    }
    public void SelectMonth()
    {      
    	wait.until(ExpectedConditions.elementToBeClickable(Month));
        SelectDate(Month, 10);
    }
    public void SelectDay()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(Day));
        SelectDate(Day, 15);
    }
    public void SelectYear()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(Year));
        SelectDate(Year,25);
    }
    public void SelectDate(WebElement elem, int value)
    {
        switch (elem.toString())
        {
            case "Year":
                elem = Year;
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                break;
            case "Month":
                elem = Month;
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                break;
            case "Day":
                elem = Day;
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                break;
        }        
        var SelectElement = new SelectElement(elem);
        SelectElement.selectByIndex(value);
    }
    public void CheckFemale()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(femaleCheckBox));
        MyClick(femaleCheckBox);

    }
    public void MyClick(WebElement element)
    {
        element.click();
    }

    public void VerifyText()
    {

        if (textDisplayed.isDisplayed())
        {

        	System.out.print("** The expected text is present **");
        }
        else
        {
        	System.out.print("** The expected text is NOT present **");
        }

    }
    public void VerifyTitle()
    {
       
        Assert.assertEquals((titleText.getText()), "Abre una cuenta");
        try
        {
            Assert.assertEquals((titleText.getText()), "Abre una cuenta");
        }
        catch (Exception ex)
        {
        	System.out.print(ex);
        }
    }
    public void DriverTitle()
    {
        String title = driver.getTitle();
        try
        {
            Assert.assertEquals("Facebook - Inicia sesión o regístrate", title);
            System.out.print("Titles matched");
        }
        catch (Exception ex)
        {
        	System.out.print(ex);
        }
    }
    public void EnterEmail() {
    	wait.until(ExpectedConditions.elementToBeClickable(mobileTextbox));
    	mobileTextbox.sendKeys("holis@mail1.com");
    	wait.until(ExpectedConditions.elementToBeClickable(mailConfirmation));
    	mailConfirmation.sendKeys("holis@mail1.com");
    	signUp.click();
    	Assert.assertEquals(true, mailErrorMessage.isDisplayed());
    }

}
