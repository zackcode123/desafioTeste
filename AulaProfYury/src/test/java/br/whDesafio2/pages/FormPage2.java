package br.whDesafio2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage2 {
	
	private WebDriver driver;
	
	private By clicaBotaoGo = By.id("save-and-go-back-button");
	
	public FormPage2(WebDriver driver) {
		this.driver = driver;
	} 
	
	public void clickGoBack() {

		driver.findElement(clicaBotaoGo).click();
	}

};