package s999_ProjetoCursoCucumber.pages;

import s999_ProjetoCursoCucumber.helper.BasePage;

public class MenuPage extends BasePage {
	
	
	
	public void acessarAcessarConta(){
		clicarLink("Contas");
	}
	
	public void acessarTelaInserirConta(){
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta(){
		clicarLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao(){
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");

	}

}
