package br.whDesafio1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private WebDriver driver;
	private By campoMudaVersao = By.id("switch-version-select");

	private By addCliente = By.cssSelector("a");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void mudarVersao(int versao) {

		WebElement element = driver.findElement(campoMudaVersao);
		Select combo = new Select(element);
		combo.selectByIndex(versao);

	}

	public void clickAddCustomer() {

		driver.findElements(addCliente).get(0).click();
	}
	
	

}
