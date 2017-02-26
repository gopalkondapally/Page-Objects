package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DisappearingElementsPage;

public class DisappearingElementsTest extends BaseTest
{
	@Test
	public void HeadingTest()
	{
		DisappearingElementsPage disElePage = new DisappearingElementsPage(driver);
		String pageHeading= disElePage.getPageHeader();
		Assert.assertEquals(pageHeading, "Disappearing Elements");
	}
	
	@Test
	public void PagesListTest()
	{
		DisappearingElementsPage disElePage = new DisappearingElementsPage(driver);
		disElePage.navigateToEachPage();
		Assert.assertTrue(disElePage.getElements().size()>0);
	}
}
