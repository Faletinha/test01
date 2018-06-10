package es.upo.qa.pageObjects.commons;

import org.openqa.selenium.WebDriver;
import es.upo.qa.pageObjects.GoogleSearchPage;


public class GooglePage extends AbstractPage {

	protected GoogleSearchPage gSearchPage;


	public GooglePage ( WebDriver driver ) {
		super ( driver );
		this.gSearchPage = new GoogleSearchPage ( driver );
	}


	@Override
	public boolean isReady () {
		return true;
	}


	public void doSearch ( String string ) {
		this.gSearchPage.doSearch ( string );
	}


	public boolean checkSearchBox () {
		return this.gSearchPage.checkSearchBox ();
	}


	public boolean checkSearchResults () {
		return this.gSearchPage.checkResults ();
	}


	public void goToPage ( int page ) {
		this.gSearchPage.goToPage ( page + 1 );
	}


	public void nextPage () {
		this.gSearchPage.goToNextPage ();
	}


	public boolean checkPagination () {
		return this.gSearchPage.checkPagination ();
	}


	public void goToResult ( int index ) {
		this.gSearchPage.goResult ( index );
	}

}
