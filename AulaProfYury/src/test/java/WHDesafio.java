




import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import br.whDesafio1.pages.FormPage;
import br.whDesafio1.pages.HomePage;


public class WHDesafio {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty
		("webdriver.chrome.driver", "C:\\Ws_GdriverOficial\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}
	

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void testCombo() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		FormPage formPage = new FormPage(driver);
	
		
		
		
		//1 - Muda versão 
		homePage.mudarVersao(1);
		homePage.clickAddCustomer();
		
		
		//2.Preencher os campos do formulário 
		formPage.insertName("Teste Sicredi");
		formPage.insertLastName("Teste");
		formPage.insertFirstName("Renildo");
		formPage.insertTel("51 9999-9999");
		formPage.insertAdrsL1("Av Assis Brasil, 3970");
		formPage.insertAdrsL2("Torre D");
		formPage.insertCity("Porto Alegre");
		formPage.insertState("RS");
		formPage.insertPostalCode("91000-000");
		formPage.insertCountry("Brasil");
		
		//2.1 .Preencher os campos do formulário 
		formPage.insertFromEmployeer("Fixter");
		formPage.insertLimiteCredito("200");
	

		//3.Clicar no botão Save
		formPage.clickSave();
		
		//4.Validar a mensagem 
		String expectedResult = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		String result = formPage.getText();
		
		assertEquals(expectedResult, result);
	}

}
