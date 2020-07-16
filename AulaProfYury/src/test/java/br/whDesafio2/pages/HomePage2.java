package br.whDesafio2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage2 {
	WebDriver driver;
	
	private By campoNome2 = By.cssSelector("input[placeholder^='Search Name']");
	
	private By clicaBotaoCheck = By.cssSelector("input[type^='checkbox']");
	
	private By clicaBotaoDelete = By.cssSelector("a[title^='Delete']");
	
	private By validaTexto = By.cssSelector("p[class^='alert-delete-multiple']");
	
	private By clicaBotaoDelete2= By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");
	
	
	public HomePage2(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void insertName2(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(campoNome2)); 
		driver.findElement(campoNome2).sendKeys(name);
	}
	
	public void clickCheckBox() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clicaBotaoCheck));
		driver.findElement(clicaBotaoCheck).click();
	}
	
	public void clickDelete() {
	
		driver.findElement(clicaBotaoDelete).click();
	}
	
	public String getText() {
		String result;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validaTexto));
		result = driver.findElement(validaTexto).getText();
		
		return result;
		
	}
	public void clickDeletePopUp() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clicaBotaoDelete2));
		driver.findElement(clicaBotaoDelete2).click();
	}
}
