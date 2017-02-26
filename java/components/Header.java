package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header 
{
public WebDriver driver;
		
	By headerLocator = By.tagName("h3");
	
	public Header(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getHeadingOfPage()
	{
		return driver.findElement(headerLocator);
	}
}
