package s999_ProjetoCursoCucumber.pages;

import s999_ProjetoCursoCucumber.helper.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}
