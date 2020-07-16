package br.whDesafio1.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	private WebDriver driver;

	private By campoNome = By.name("customerName");
	private By campoltsNome = By.name("contactLastName");
	private By campoFrtNome = By.name("contactFirstName");
	private By campoTel = By.name("phone");
	private By campoAdrsL1 = By.name("addressLine1");
	private By campoAdrsL2 = By.name("addressLine2");
	private By campoCity = By.name("city");
	private By campoState = By.name("state");
	private By campoPostalCode = By.name("postalCode");
	private By campoCountry = By.name("country");

	private By campoFromEmployeer = By.id("field_salesRepEmployeeNumber_chosen");
	private By campoLimiteCredito = By.name("creditLimit");

	private By clicaBotao = By.id("form-button-save");
	
	private By validaTexto = By.xpath("//*[@id=\"report-success\"]/p");

	public FormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void insertName(String name) {
		driver.findElement(campoNome).sendKeys(name);
	}

	public void insertLastName(String lastName) {
		driver.findElement(campoltsNome).sendKeys(lastName);
	}

	public void insertFirstName(String firtName) {
		driver.findElement(campoFrtNome).sendKeys(firtName);
	}

	public void insertTel(String tel) {
		driver.findElement(campoTel).sendKeys(tel);
	}

	public void insertAdrsL1(String adress) {
		driver.findElement(campoAdrsL1).sendKeys(adress);
	}

	public void insertAdrsL2(String adress) {
		driver.findElement(campoAdrsL2).sendKeys(adress);
	}

	public void insertCity(String cidade) {
		driver.findElement(campoCity).sendKeys(cidade);
	}

	public void insertState(String estado) {
		driver.findElement(campoState).sendKeys(estado);
	}

	public void insertPostalCode(String cep) {
		driver.findElement(campoPostalCode).sendKeys(cep);
	}

	public void insertCountry(String pais) {
		driver.findElement(campoCountry).sendKeys(pais);
	}

	public void clickSave() {

		driver.findElement(clicaBotao).click();
	}
	
	public String getText() {
		String result;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(validaTexto));
		result = driver.findElement(validaTexto).getText();

		return result;
		
	}

	public void insertFromEmployeer(String nome) {
		driver.findElement(campoFromEmployeer).click();
		List<WebElement> listElement = driver.findElements(By.className("active-result"));
		for (WebElement webElement : listElement) {
			if (webElement.getText().trim().toLowerCase().equals(nome.trim().toLowerCase())) {
				webElement.click();
				break;
			}
		}
	}

	public void insertLimiteCredito(String credito) {
		driver.findElement(campoLimiteCredito).sendKeys(credito);
	}
};
