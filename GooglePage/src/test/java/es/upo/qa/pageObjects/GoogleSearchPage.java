package es.upo.qa.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import es.upo.qa.pageObjects.commons.AbstractPage;


public class GoogleSearchPage extends AbstractPage {

	private static String SEARCH_BOX_ID = "lst-ib";
	private static String SEARCH_RESULTS = "resultStats";
	private static String PAGE_NAV = "nav";
	private static String PAGE_NAV_9999 = "#nav>tbody:nth-child(1)>tr:nth-child(1)>td:nth-child(9999)>a:nth-child(1)";
	private static String PAGE_NEXT = "#pnnext>span:nth-child(2)";
	private static String RESULT_ITEM_9999 = "#rso>div>div>div:nth-child(9999)>div>div>h3>a";
	private static String REPLACE_TAG = "9999";


	public GoogleSearchPage ( WebDriver driver ) {
		super ( driver );
	}


	@Override
	public boolean isReady () {
		// TODO Auto-generated method stub
		return false;
	}


	public void doSearch ( String string ) {
		WebElement searchBox = this.findElementById ( SEARCH_BOX_ID );
		searchBox.sendKeys ( string );
		searchBox.sendKeys ( Keys.RETURN );
	}


	public boolean checkResults () {
		try {
			this.findElementById ( SEARCH_RESULTS );
			return true;
		}
		catch ( NoSuchElementException e ) {
			return false;
		}
	}


	public boolean checkSearchBox () {
		try {
			this.findElementById ( SEARCH_BOX_ID );
			return true;
		}
		catch ( NoSuchElementException e ) {
			return false;
		}
	}


	public boolean checkPagination () {
		try {
			return this.findElementById ( PAGE_NAV ).isDisplayed ();
		}
		catch ( NoSuchElementException e ) {
			return false;
		}
	}


	public void goToPage ( int page ) {
		goTo ( PAGE_NAV_9999 , page );
	}


	public void goToNextPage () {
		WebElement pageLink = this.findElementByCss ( PAGE_NEXT );
		pageLink.click ();
	}


	public void goResult ( int index ) {
		goTo ( RESULT_ITEM_9999 , index );
	}


	public void goTo ( String selector , int index ) {
		String selaux = selector;
		String normalicedString = normalizeIndex ( selaux , index );
		this.findElementByCss ( normalicedString ).click ();
	}


	private String normalizeIndex ( String selector , int index ) {
		String normalicedInt = Integer.toString ( index );
		return selector.replace ( "(" + REPLACE_TAG + ")" , "(" + normalicedInt + ")" );
	}

}
