package s999_ProjetoCursoCucumber.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import s999_ProjetoCursoCucumber.pages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Contas.feature",
		glue = "s999_ProjetoCursoCucumber.steps",
		tags = {"~@ignore"},
		plugin = {"pretty","html:target/report-html","json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
				 )

	

	public class RunnerTest {
	
	private static LoginPage login = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		login.reset("daviluis7@gmail.com","luis1601");
	}
	

	
}
