package pageobjects;

import selectors.UnitTestSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class UnitTest
{
	//System.setProperty("webdriver.firefox.marionette","C:\\Automation Testing\\geckodriver-v0.19.1-win64\\geckodriver.exe");

	public static WebDriver driver = new FirefoxDriver();
	
	private static WebDriverWait wait = new WebDriverWait(driver,10);

	public void navigateToEtsyHomePage()
	{
        driver.get(UnitTestSelectors.ETSY_HOMEPAGE_URL);
    }

    public void acceptEtsyPrivacySettings()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UnitTestSelectors.ETSY_ACCEPT_COOKIES_POPUP)));
        //System.out.println("Found the Alert popup");
        driver.findElement(By.xpath(UnitTestSelectors.ETSY_ACCEPT_COOKIES_BUTTON)).click();
    }

    public void enterPartialSearchString(String pstring)
    {
        driver.findElement(By.id(UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_BAR_ID)).sendKeys(pstring);
        //System.out.println("Entered search string");
    }

    public void searchGivenString(String searchstring)
    {

        Actions action = new Actions(driver);
        WebElement searchDropDown = driver.findElement(By.id(UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_BAR_ID));
        action.moveToElement(searchDropDown).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_OPTIONS_LIST)));

        List<WebElement> searchOptions = driver.findElements(By.xpath(UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_OPTIONS_LIST));

        for (int i=1; i<=searchOptions.size(); i++)
        {
            String index = Integer.toString(i);
            String stringSelector = UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_OPTIONS_LIST_STRING_SELECTOR.replace("z", index);
            
            if(driver.findElement(By.xpath(stringSelector)).getText().equals(searchstring))
            {
                searchOptions.get(i-1).click();
                driver.findElement(By.xpath(UnitTestSelectors.ETSY_HOME_PAGE_SEARCH_BUTTON)).click();
                break;
            }

	        else
	        {
	        	if(i>=searchOptions.size());
	        	{
	        		System.out.println("Couldn't find search string");
	        		driver.close();
	        		driver.quit();
	        	}
	        }
        }

    }

    public void sortSearchResultsBy(String sortBy)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UnitTestSelectors.ETSY_SEARCH_RESULTS_SORT_BY_DROPDOWN_BUTTON)));

        driver.findElement(By.xpath(UnitTestSelectors.ETSY_SEARCH_RESULTS_SORT_BY_DROPDOWN_BUTTON)).click();

        driver.findElement(By.linkText(sortBy)).click();
        
    }

    public void getFirstNPrices(int nPrices)
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UnitTestSelectors.ETSY_SEARCH_RESULTS_PRICE_SELECTOR)));
    	
        List<WebElement> PriceList = driver.findElements(By.xpath(UnitTestSelectors.ETSY_SEARCH_RESULTS_PRICE_SELECTOR));

        System.out.println("Sorting by Lowest Price and listing the top "+nPrices+" prices:");
        
        for(int i=0; i< nPrices; i++)
        {
            System.out.println("£"+PriceList.get(i).getText());
        }

    }

}