package s999_ProjetoCursoCucumber.pages;

import org.openqa.selenium.By;

import s999_ProjetoCursoCucumber.helper.BasePage;

public class ContasPage extends BasePage {

	public void setNomeConta(String nome) {
		escrever("nome", nome);
	}
	
	public void setSemNome(String nome) {
		escrever("nome","");
	}
	
	public void salvarConta(){
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro(){
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public String obterMensagemSemNome(){
		return obterTexto(By.xpath("/html/body/div[1]"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
