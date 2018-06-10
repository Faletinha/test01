package es.upo.qa.pageObjects.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {

	protected WebDriver driver;
	protected Integer timeout = 10; // seconds


	public AbstractPage ( WebDriver driver ) {
		this.driver = driver;
		driver.manage ().timeouts ().implicitlyWait ( timeout , TimeUnit.SECONDS );
	}


	public boolean isElementVisible ( String xpath ) {
		boolean visible = false;
		WebElement element = this.findElementByXPath ( xpath );
		visible = element != null && element.isDisplayed ();
		return visible;
	}


	public WebElement findElementByXPath ( String xpath ) {
		WebElement element = null;
		element = driver.findElement ( By.xpath ( xpath ) );
		return element;
	}


	public List <WebElement> findElementsByXPath ( String xpath ) {
		List <WebElement> elements = new ArrayList <WebElement> ();
		elements = driver.findElements ( By.xpath ( xpath ) );
		return elements;
	}


	public WebElement findElementById ( String id ) {
		return findDynamicElement ( By.id ( id ) , 20 );
	}


	public WebElement findElementByName ( String name ) {
		return driver.findElement ( By.name ( name ) );
	}


	public WebElement findElementByCss ( String elem , String attr , String value ) {
		return driver.findElement ( By.cssSelector ( elem + "[" + attr + "='" + value + "']" ) );
	}


	public WebElement findElementByCss ( String selector ) {
		return findDynamicElement ( By.cssSelector ( selector ) , 20 );
	}


	public WebDriver getDriver () {
		return this.driver;
	}


	public WebElement findDynamicElement ( By by , int timeOut ) {
		System.out.println ( "trying to find " + by.toString () );
		WebDriverWait wait = new WebDriverWait ( driver , timeOut );
		WebElement element = wait.until ( ExpectedConditions.visibilityOfElementLocated ( by ) );
		return element;
	}


	public abstract boolean isReady ();
}
