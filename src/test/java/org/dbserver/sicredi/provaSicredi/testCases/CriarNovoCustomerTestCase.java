package org.dbserver.sicredi.provaSicredi.testCases;

import org.dbserver.sicredi.provaSicredi.auxi.TestBase;
import org.dbserver.sicredi.provaSicredi.tasks.CadastroCustomerTask;
import org.dbserver.sicredi.provaSicredi.tasks.TelaInicialTask;
import org.testng.annotations.Test;

public class CriarNovoCustomerTestCase extends TestBase {
	
	@Test
	public void CriarNovoCustomer() {
		
		TelaInicialTask telaInicial = new TelaInicialTask(driver);
		CadastroCustomerTask cadastroCustomer = new CadastroCustomerTask(driver);
		
		
		telaInicial.trocaVersaoDoBootstrap();
		telaInicial.criarNovoCustomer();
		
		cadastroCustomer.cadastroDeCustomer(informacoes);
		cadastroCustomer.verificaSucessoDoCadastro();
		
	}

}
