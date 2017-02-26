package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisappearingElementsPage extends BasePage
{
   By elementlistLocator = By.xpath(".//div[@id='content']//a");
   
	public DisappearingElementsPage(WebDriver driver) 
	{
		super(driver);
		visit("disappearing_elements");
	}
	
	public String getPageHeader() 
	{
		return getHeading();
	}
	
	public List<WebElement> getElements()
	{
		return findElements(elementlistLocator);
	}
	
	public void navigateToEachPage()
	{
		//Finding all the elements
		List<WebElement> pagesList = getElements();
		System.out.println(pagesList.size());

		//Creating String array
		String[] listText = new String [pagesList.size()];
		int i=0;
		
		//Storing List elements text into String array
		for(WebElement a: pagesList)
		{
			listText[i]=a.getText();
			i++;
		}
		
		//Navigating to Each Page and returning to Home Page
		for(int j=0;j<listText.length;j++)
		{
			By linkTextLocator = By.linkText(listText[j]);
			System.out.println("Clicking on this link:: "+getText(linkTextLocator));
			clickOn(linkTextLocator);
            moveBackward();
		}
	}

}
