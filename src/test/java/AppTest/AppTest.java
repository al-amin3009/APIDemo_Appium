package AppTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.DragAndDropPage;
import PageObjectModel.ExpandableListsPage;
import PageObjectModel.HomePage;
import PageObjectModel.ViewPage;

public class AppTest extends BaseTest{
	
	@Test(priority=1, description= "Navigate to Customa Adapter and perform Long press")
	public void PopupMenu() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.NavigateToViewsPage("Views").click();
		
		ViewPage viewPage = new ViewPage(driver);
		viewPage.NavigateToPage("Expandable Lists").click();
		
		ExpandableListsPage expandableLists = new ExpandableListsPage(driver);
		expandableLists.selectCustomAdapter("1. Custom Adapter").click();
		expandableLists.longPressPeopleNames();
		Assert.assertTrue(
				expandableLists.isSampleActionPopupDisplayed(), 
	            "Sample action popup was not displayed"
	        );
		
		navigateBack(3);
		
		Thread.sleep(2000);
	}
    
	@Test(priority = 2, description = "Perform Drag and Drop")
    public void testDragAndDrop() {
		ViewPage viewPage = new ViewPage(driver);
		viewPage.NavigateToPage("Drag and Drop").click();
		
		DragAndDropPage dragNDropPage = new DragAndDropPage(driver);
		dragNDropPage.performDragAndDrop();
		String dragResult = dragNDropPage.getDragResultText();
		Assert.assertEquals(
	            dragResult, 
	            "Dropped!", 
	            "Drag and drop result text does not match expected"
	        );
	}
}
