package s999_ProjetoCursoCucumber.steps;

import static s999_ProjetoCursoCucumber.helper.DriverFactory.getDriver;
import static s999_ProjetoCursoCucumber.helper.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import s999_ProjetoCursoCucumber.helper.BasePage;
import s999_ProjetoCursoCucumber.helper.Propriedades;
import s999_ProjetoCursoCucumber.pages.ContasPage;
import s999_ProjetoCursoCucumber.pages.LoginPage;
import s999_ProjetoCursoCucumber.pages.MenuPage;

public class ContasSteps {
	
	
	private BasePage page = new BasePage();
	private LoginPage login = new LoginPage();
	private MenuPage menu = new MenuPage();
	private ContasPage conta = new ContasPage();

	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		login.acessarTelaInicial();
	}

	@Quando("^informo o usuário \"(.*?)\"$")
	public void informoOUsuário(String email) throws Throwable {
		login.setEmail(email);
	}

	@Quando("^a senha \"(.*?)\"$")
	public void aSenha(String senha) throws Throwable {
		login.setSenha(senha);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		login.entrar();
		Assert.assertEquals("Bem vindo, Davi!", page.obterTexto(By.xpath("/html/body/div[1]")));
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
		menu.acessarTelaPrincipal();
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		menu.acessarAcessarConta();

	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		menu.acessarTelaInserirConta();
	}

	@Quando("^informo a conta \"(.*?)\"$")
	public void informoAConta(String nome) throws Throwable {
		conta.setNomeConta(nome);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		conta.salvarConta();
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
		Assert.assertEquals("Conta adicionada com sucesso!", conta.obterMensagemSucesso());
	}

	@Então("^sou notificado que o nome da conta é obrigatório$")
	public void souNotificarQueONomeDaContaÉObrigatório() throws Throwable {
		Assert.assertEquals("Informe o nome da conta", conta.obterMensagemSemNome());
	}

	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
		Assert.assertEquals("Já existe uma conta com esse nome!", conta.obterMensagemErro());
	}
	
	@Então("^recebo a mensagem \"(.*?)\"$")
	public void receboAMensagem(String experado) throws Throwable {
		String atual = conta.obterMensagemSemNome();
		Assert.assertEquals(experado, atual);
		
	}

	@Before
	public void inicia() {
		System.out.println("Começando aqui");
	}
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)getDriver())
                                      .getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target\\screenshot\\"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0)
	public void finaliza() throws IOException {
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
		System.out.println("Terminando");
	}
}
