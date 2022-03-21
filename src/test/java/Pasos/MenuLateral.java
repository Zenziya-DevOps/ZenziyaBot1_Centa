package Pasos;

import java.util.ArrayList;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;
import Tools.DriverManagerHL;

 
public class MenuLateral {
	WebDriver driver;
	
	// Metodo que utiliza los 4 parametros como niveles de navegacoin
	public void menuTransferencias(Datasources data,Reports report, DriverManagerHL DM, int iteration, String name, Repo_WebRepository repo) throws InterruptedException {
		
		//SWITCH TO CORRECT IFRAME
		switchToFrame(DM, repo);
		
		//ADD THE STEPS BELOW
		report.AddLine("Se ingresa al menu: Transferencias");
		System.out.println("Se ingresa al menu: Transferencias");
		repo.get_lnkTransferencias().click();
		Thread.sleep(500);
		
	}
	
	public void menuTerceros(Datasources data,Reports report, DriverManagerHL DM, int iteration, String name, Repo_WebRepository repo) throws InterruptedException {

		//SWITCH TO CORRECT IFRAME
		switchToFrame(DM, repo);
				
		//ADD THE STEPS BELOW
		report.AddLine("Se selecciona Terceros");
		System.out.println("Se selecciona Terceros");
		report.Screenshot(name);
		repo.get_lnkTerceros().click();
		
	}
	
	private void switchToFrame (DriverManagerHL DM, Repo_WebRepository repo) {
		
		driver = DM.getActualDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(repo.get_leftIframe());
		
	}
	
}
