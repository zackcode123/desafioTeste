package desafio2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.whDesafio1.pages.FormPage;
import br.whDesafio1.pages.HomePage;
import br.whDesafio2.pages.FormPage2;
import br.whDesafio2.pages.HomePage2;

public class WHDesafio2 {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Ws_GdriverOficial\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");

		HomePage homePage = new HomePage(driver);
		FormPage formPage = new FormPage(driver);
		
		// 1 - Muda versão
		homePage.mudarVersao(1);
		homePage.clickAddCustomer();

		// 2.Preencher os campos do formulário
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

		// 2.1 .Preencher os campos do formulário
		formPage.insertFromEmployeer("Fixter");
		formPage.insertLimiteCredito("200");

		// 3.Clicar no botão Save
		formPage.clickSave();

		// 4.Validar a mensagem
		//String expectedResult = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		//String result = formPage.getText();

		//assertEquals(expectedResult, result);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

	@Test
	public void test() {
		HomePage2 homePage2 = new HomePage2(driver);
		FormPage2 formPage2 = new FormPage2(driver);
		
		//1.Clicar no link Go back to list
		formPage2.clickGoBack();
		
		//2.Clicar na coluna “Search Name” 
		homePage2.insertName2("Teste Sicredi2");
		
		//3.Clicar no checkbox abaixo da palavra Actions
		homePage2.clickCheckBox();
		
		//4.Clicar no botão Delete
		homePage2.clickDelete();
		
		//5.Validar o texto 
		String expectedResult = "Are you sure that you want to delete those 10 items?";
		String result = homePage2.getText();

		assertEquals(expectedResult, result);
		
		//6.Clicar no botão Delete da popup
		homePage2.clickDeletePopUp();
		
		
	}

}
