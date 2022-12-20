package s999_ProjetoCursoCucumber.pages;

import static s999_ProjetoCursoCucumber.helper.DriverFactory.getDriver;
import static s999_ProjetoCursoCucumber.helper.DriverFactory.killDriver;

import org.openqa.selenium.By;

import s999_ProjetoCursoCucumber.helper.BasePage;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/");
	}

	public void setEmail(String email) {
		escrever("email", email);
	}

	public void setSenha(String senha) {
		escrever("senha", senha);
	}

	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}

	public void login(String email, String senha) {
		acessarTelaInicial();
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	public void reset(String email, String senha) {
		acessarTelaInicial();
		setEmail(email);
		setSenha(senha);
		entrar();
		clicarBotao(By.xpath("/html/body/footer/span/a"));
		System.out.println(obterTexto(By.xpath("/html/body/div[1]")));
		killDriver();
		
	}

}
