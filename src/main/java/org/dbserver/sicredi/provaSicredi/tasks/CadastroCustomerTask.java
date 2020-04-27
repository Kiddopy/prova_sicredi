package org.dbserver.sicredi.provaSicredi.tasks;

import java.util.List;
import java.util.Properties;

import org.dbserver.sicredi.provaSicredi.appObjects.CadastroCustomerAppObject;
import org.dbserver.sicredi.provaSicredi.auxi.ExtentTestManager;
import org.dbserver.sicredi.provaSicredi.auxi.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class CadastroCustomerTask {
	
	private CadastroCustomerAppObject cadastro;
	
	public CadastroCustomerTask(WebDriver driver) {
		this.cadastro = new CadastroCustomerAppObject(driver);
	}
	
	public void cadastroDeCustomer(Properties propriedades) {
		cadastro.getNomeTextField().sendKeys(propriedades.getProperty("name"));
		ExtentTestManager.log(Status.INFO, "Nome inserido");
		
		cadastro.getLastNameTextField().sendKeys(propriedades.getProperty("lastName"));
		ExtentTestManager.log(Status.INFO, "Último nome inserido");
		
		cadastro.getContactFirstName().sendKeys(propriedades.getProperty("contactFirstName"));
		ExtentTestManager.log(Status.INFO, "Primeiro nome pra contato inserido");
		
		cadastro.getPhoneTextField().sendKeys(propriedades.getProperty("phone"));
		ExtentTestManager.log(Status.INFO, "Telefone inserido");
		
		cadastro.getAddressLine1TextField().sendKeys(propriedades.getProperty("addressLine1"));
		ExtentTestManager.log(Status.INFO, "Endereço primário inserido");
		
		cadastro.getAddressLine2TextField().sendKeys(propriedades.getProperty("addressLine2"));
		ExtentTestManager.log(Status.INFO, "Endereço secundário inserido");
		
		cadastro.getCityTextField().sendKeys(propriedades.getProperty("city"));
		ExtentTestManager.log(Status.INFO, "Cidade inserida");
		
		cadastro.getStateTextField().sendKeys(propriedades.getProperty("state"));
		ExtentTestManager.log(Status.INFO, "Estado inserido");
		
		cadastro.getPostalCodeTextField().sendKeys(propriedades.getProperty("postalCode"));
		ExtentTestManager.log(Status.INFO, "CEP inserido");
		
		cadastro.getCountryTextField().sendKeys(propriedades.getProperty("country"));
		ExtentTestManager.log(Status.INFO, "País inserido");
		
	    cadastro.getEmployerSelect().click();
	    selecionaItemDaListaDeEmployees(propriedades.getProperty("employeer"));
		
		cadastro.getCreditLimitTextField().sendKeys(propriedades.getProperty("creditLimit"));
		ExtentTestManager.log(Status.INFO, "Limite de crédito inserido");
		
		cadastro.getSaveButton().click();
	}
	
	private void selecionaItemDaListaDeEmployees(String item) {
		List<WebElement> elementos = cadastro.getListaDeEmployees();
		for(WebElement elemento : elementos) {
			if(elemento.getText().contentEquals(item)) {
				elemento.click();
				ExtentTestManager.log(Status.INFO, "Employee inserido");	
			}
		}
	}
	
	
	public void selecionaVoltarParaLista() {
		cadastro.getGoBackToListButton().click();
	}
	
	public void verificaSucessoDoCadastro() {
		String mensagemFinal = cadastro.getSuccessMessage().getText();
		if(mensagemFinal.contains("Your data has been successfully stored into the database.")) {
			ExtentTestManager.log(Status.PASS, "O cadastro foi efetuado com sucesso!", ScreenShot.captureToBase64());
		}else {
			ExtentTestManager.log(Status.FAIL, "Ocorreu um erro ao cadastrar!", ScreenShot.captureToBase64());
		}
	}

}
