package org.dbserver.sicredi.provaSicredi.appObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroCustomerAppObject {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CadastroCustomerAppObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public WebElement getNomeTextField() {
		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("field-customerName"))));
	}
	
	public WebElement getLastNameTextField() {
		return driver.findElement(By.id("field-contactLastName"));
	}
	
	public WebElement getContactFirstName() {
		return driver.findElement(By.id("field-contactFirstName"));
	}
	
	public WebElement getPhoneTextField() {
		return driver.findElement(By.id("field-phone"));
	}
	
	public WebElement getAddressLine1TextField() {
		return driver.findElement(By.id("field-addressLine1"));
	}
	
	public WebElement getAddressLine2TextField() {
		return driver.findElement(By.id("field-addressLine2"));
	}
	
	public WebElement getCityTextField() {
		return driver.findElement(By.id("field-city"));
	}
	
	public WebElement getStateTextField() {
		return driver.findElement(By.id("field-state"));
	}
	
	public WebElement getPostalCodeTextField() {
		return driver.findElement(By.id("field-postalCode"));
	}
	
	public WebElement getCountryTextField() {
		return driver.findElement(By.id("field-country"));
	}
	
	
	public WebElement getEmployerSelect() {
		return driver.findElement(By.id("field_salesRepEmployeeNumber_chosen"));
	}
	
	
	public List<WebElement> getListaDeEmployees() {
	 	return driver.findElements(By.className("active-result"));
	}
	
	
	public WebElement getCreditLimitTextField() {
		return driver.findElement(By.id("field-creditLimit"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("form-button-save"));
	}
	
	//Your data has been successfully stored into the database. 
	public WebElement getSuccessMessage() {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("report-success"))));
	}

	public WebElement getGoBackToListButton() {
		return driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]"));
	}
	
	
}
