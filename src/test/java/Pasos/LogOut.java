package Pasos;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;
import Tools.DriverManagerHL;

public class LogOut {
	WebDriver driver;

	public void logOut(Datasources data, Reports report, DriverManagerHL DM, int iteration, String name, Repo_WebRepository repo) {

		//SWITCH TO CORRECT IFRAME
		switchToFrame(DM, repo);

		//ADD THE STEPS BELOW
		report.AddLine("Se hace click en el boton Salir");
		System.out.println("Se hace click en el boton Salir");
		repo.get_btnSalir().click();
		
		report.AddLine("Se hace click en el boton Aceptar");
		System.out.println("Se hace click en el boton Aceptar");
		driver = DM.getActualDriver();
		driver.switchTo().alert().accept();
		
	}

	private void switchToFrame (DriverManagerHL DM, Repo_WebRepository repo) {

		driver = DM.getActualDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(repo.get_topIframe());

	}

}
