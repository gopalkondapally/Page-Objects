package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.Header;


public class BasePage 
{
	public WebDriver driver;
	String BASE_URL="https://the-internet.herokuapp.com/";
	
	// Constructor which initializes the driver
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// Navigates to the default the-internet page 
	public void visit()
	{
		driver.get(BASE_URL);
	}
	
	// Navigates to the web site given of the URL
	public void visit(String url)
	{
		driver.get(BASE_URL+url);
	}
	
	// Finds the element by locator
	public WebElement find(By locator)
	{
		waitfor(locator);
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);
	}
	// Returns title of the page 
	public String title()
	{
		return driver.getTitle();
	}
	
	// Clicks on an element using the locator
	public void clickOn(By locator)
	{
		find(locator).click();
    }
	
	// Enters text when locator is passed
	public void enter(By locator,String inputText)
	{
		clear(locator);
		find(locator).sendKeys(inputText);
	}
	
	public void clear(By locator)
	{
		find(locator).clear();
	}
	
	// Returns heading of the page
	public String getHeading()
	{
		Header header = new Header(driver);
		String heading = header.getHeadingOfPage().getText();
		System.out.println(heading+" is loaded");
		return heading;
	}
	
	// Returns a boolean value based on whether element is present or not
	public boolean isDisplayed(By locator)
	{
		try
		{
			return find(locator).isDisplayed();
		}
		catch(NoSuchElementException exception)
		{
			return false;
		}
	}
	
	// Waits for an element by locator, Default wait time is 10 seconds
	public void waitfor(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	public void refresh()
	{
		driver.navigate().refresh();
	}
	
	public void moveBackward()
	{
		driver.navigate().back();
	}
	
	public void moveFoward()
	{
		driver.navigate().forward();
	}
}