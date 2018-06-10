package es.upo.qa.selenium;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import es.upo.qa.pageObjects.commons.GooglePage;


public class GoogleSearchTest extends DefaultTest {

	GooglePage gp = null;


	@Test
	public void checkSearchBox () {
		this.goTo ( "https://www.google.es" );
		assertTrue ( gp.checkSearchBox () );
	}


	@Test
	public void doSearch () {
		this.goTo ( "https://www.google.es" );
		gp.doSearch ( "asd" );
	}


	@BeforeTest
	public void enterGoogle () {
		gp = new GooglePage ( driver );
	}


	@Test
	public void doSearchAndCheckResult () {
		gp.doSearch ( "asd" );
		assertTrue ( gp.checkSearchResults () );
	}


	@Test
	public void doSearchAndCheckPagination () {
		this.goTo ( "https://www.google.es" );
		gp.doSearch ( "asd" );
		assertTrue ( gp.checkPagination () );
	}


	@Test
	public void doSearchAccessPageAndFirstResult () {
		this.goTo ( "https://www.google.es" );
		gp.doSearch ( "asd" );
		gp.goToPage ( 2 );
		gp.goToResult ( 1 );
	}

}
