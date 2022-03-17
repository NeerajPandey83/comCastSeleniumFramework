package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

/**
 * this class consist of all generic method which are contain webdriver specific reusable actions
 * @author 91834
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 * this method will wait for 10 second for the element to clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * this method will wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method wait for the element to be clicked , its custom wait 
       created to avoid elemenInterAceptable Exception
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClic(WebElement element) throws Throwable
	{
		int count =0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(3000);
				count++;
			}
		}
	}
	
	/**
	 * this method will select the data from dropdouwn using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	
	/**
	 * this method will select the data from dropdouwn using text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will select the data from dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	/**
	 * This method will perform action double click on element
	 * @param driver
	 * @param target
	 */
	public void actoinsDoubleClick(WebDriver driver,WebElement target)
	{
		Actions act = new Actions(driver);
		act.doubleClick(target).perform();
	}
	
	/**
	 * This method will perform double click 
	 * @param driver
	 */
	public void actoinsDoubleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform right click on element
	 * @param driver
	 * @param target
	 */
	public void selectRightClick(WebDriver driver,WebElement target)
	{
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
	}
	
	/**
	 * This method will perform right click 
	 * @param driver
	 */
	public void selectRightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform move to element action
	 * @param driver
	 * @param target
	 */
	public void selectMouseHouer(WebDriver driver,WebElement target)
	{
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
	}
	
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	
	/**
	 * This method will press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKeyPress(WebDriver driver) throws Throwable
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER);
		
	}
	
	/**
	 * This method will switch the frame based on index of the element
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * This method will switch the frame based on name or Id of the element
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method use for to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
	 TakesScreenshot ts=(TakesScreenshot)driver; 
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File("./screenshot/"+screenshotName+".PNG"); 
	 Files.copy(src, dest);
			}
	
	/**
	 * This method used for scrolling action in webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	int y= element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	/**
	 * This method perform random scroll
	 * @param driver
	 */
	public void scrollToWebElement(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	/** 
	 * Accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
	
	/**
	 * Cancel alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method use to switch window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		// step 1: use getwindowhandels to capture all window id
		Set<String> windows = driver.getWindowHandles();
		
		//step 2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step 3: check whether there is next window
		while(it.hasNext())
		{
			//step 4: capture current window id
			String winId = it.next();
			
			//step 5: switch to current window and capture title
			String currentWindowTitle = driver.switchTo().window(winId).getTitle();
			
			// step 6: check whether the current window is expected
			if(currentWindowTitle.contains(partialWinTitle)) 
			{
				break;
			}
			
		}
	}
	
	/**
	 * This method use to perform keyboard action press the key through Robot class 
	 * @throws Throwable
	 */
	public void robotClass() throws Throwable
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method use to perform keyboard action release the key
	 * @throws Throwable
	 */
	public void robotKeyRelease() throws Throwable
	{
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
