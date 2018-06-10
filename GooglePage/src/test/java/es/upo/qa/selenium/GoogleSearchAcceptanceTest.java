package es.upo.qa.selenium;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import es.upo.qa.pageObjects.commons.GooglePage;


public class GoogleSearchAcceptanceTest extends DefaultTest {

	GooglePage gp = null;


	@BeforeTest
	public void enterGoogle () {
		gp = new GooglePage ( driver );
	}


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

}
