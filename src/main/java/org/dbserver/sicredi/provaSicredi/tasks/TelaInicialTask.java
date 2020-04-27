package org.dbserver.sicredi.provaSicredi.tasks;

import org.dbserver.sicredi.provaSicredi.appObjects.TelaInicialAppObject;
import org.dbserver.sicredi.provaSicredi.auxi.ExtentTestManager;
import org.dbserver.sicredi.provaSicredi.auxi.ScreenShot;
import org.dbserver.sicredi.provaSicredi.auxi.WaitDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class TelaInicialTask {

	private TelaInicialAppObject telaInicial;
	private WaitDriver wait;
	
	public TelaInicialTask(WebDriver driver) {
		this.telaInicial = new  TelaInicialAppObject(driver);
		this.wait = new WaitDriver(driver);
	}
	
	public void trocaVersaoDoBootstrap() {
		Select lista = new Select(telaInicial.getTrocarVersaoSelect());
		lista.selectByValue("bootstrap_theme_v4");
	}
	
	public void criarNovoCustomer() {
		telaInicial.getAddCustomerButton().click();
	}
	
	private void pesquisarCustomer(String nomeDoCustomer) {
		telaInicial.getPesquisaNomeTextField().clear();
		telaInicial.getPesquisaNomeTextField().sendKeys(nomeDoCustomer);
		telaInicial.getPesquisaNomeTextField().sendKeys(Keys.ENTER);
		
		wait.waitAllRequest();
		ExtentTestManager.log(Status.INFO, "Pesquisa feita pelo nome do customer!");
	}
	
	private boolean customerExiste(String nomeDoCustomer) {
		String nomeDaPrimeiraLinha = telaInicial.getNamePesquisa().getText();
		if(nomeDaPrimeiraLinha.contentEquals(nomeDoCustomer)) {
			ExtentTestManager.log(Status.INFO, "Customer encontrado!");
			return true;
		}
		return false;
	}
	
	public void deletaCustomer(String nomeDoCustomer) {
		pesquisarCustomer(nomeDoCustomer);
	    if(customerExiste(nomeDoCustomer)) {
	    	telaInicial.getSelecionarTudoCheckBox().click();
			telaInicial.getDeleteButton().click();	
			ExtentTestManager.log(Status.INFO, "Clique feito em 'Deletar'", ScreenShot.captureToBase64());
			wait.waitAllRequest();
			telaInicial.getDeleteConfirmationButton().click();	
			ExtentTestManager.log(Status.INFO, "Deletar confirmado!'", ScreenShot.captureToBase64());
			wait.waitAllRequest();
	    }else {
	    	ExtentTestManager.log(Status.INFO, "Customer não encontrado!", ScreenShot.captureToBase64());
	    }
	}
	
	public void verificaSeOCustomerFoiDeletado(String nomeDoCustomer) {
		pesquisarCustomer(nomeDoCustomer);
		int numeroDeResultados = Integer.parseInt(telaInicial.getNumeroDeResultadosTextField().getText());
		if(numeroDeResultados == 0) {
			ExtentTestManager.log(Status.PASS, "Customer deletado com sucesso!", ScreenShot.captureToBase64());
		}else {
			ExtentTestManager.log(Status.FAIL, "Algo deu errado ao deletar o customer!", ScreenShot.captureToBase64());
		}
		
	}

}

