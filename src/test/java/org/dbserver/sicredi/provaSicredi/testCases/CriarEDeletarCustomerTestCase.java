package org.dbserver.sicredi.provaSicredi.testCases;

import org.dbserver.sicredi.provaSicredi.auxi.TestBase;
import org.dbserver.sicredi.provaSicredi.tasks.CadastroCustomerTask;
import org.dbserver.sicredi.provaSicredi.tasks.TelaInicialTask;
import org.testng.annotations.Test;

public class CriarEDeletarCustomerTestCase extends TestBase {
	
	@Test
    public void CriarEDeletarCustomer() {
		
		TelaInicialTask telaInicial = new TelaInicialTask(driver);
		CadastroCustomerTask cadastroCustomer = new CadastroCustomerTask(driver);
		String nomeDoCustomer = informacoes.getProperty("name");
				
		telaInicial.trocaVersaoDoBootstrap();
		telaInicial.criarNovoCustomer();
		
		cadastroCustomer.cadastroDeCustomer(informacoes);
		cadastroCustomer.verificaSucessoDoCadastro();
		
		cadastroCustomer.selecionaVoltarParaLista();
		telaInicial.deletaCustomer(nomeDoCustomer);
		telaInicial.verificaSeOCustomerFoiDeletado(nomeDoCustomer);
		
	}
}
