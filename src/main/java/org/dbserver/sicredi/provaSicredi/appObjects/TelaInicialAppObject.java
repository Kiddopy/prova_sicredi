package org.dbserver.sicredi.provaSicredi.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaInicialAppObject {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public TelaInicialAppObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public WebElement getTrocarVersaoSelect() {
		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("switch-version-select"))));
	}
	
	public WebElement getAddCustomerButton() {
		return driver.findElement(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a"));
	}
	
	public WebElement getPesquisaNomeTextField() {
		return driver.findElement(By.name("customerName"));
	}
	
	public WebElement getSelecionarTudoCheckBox() {
		return driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input"));
	}
	
	public WebElement getDeleteButton() {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a"))));
	}
	
	public WebElement getNamePesquisa() {
		return driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[3]"));
	}
	
	public WebElement getDeleteConfirmationButton() {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]"))));
	}
	
	public WebElement getNumeroDeResultadosTextField() {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[3]/div[4]/span[3]"))));
	}
	
}
