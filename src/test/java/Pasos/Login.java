package Pasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;
import Tools.DriverManagerHL;

 
public class Login {
	WebDriver driver;

	public void logIn(Datasources data,Reports report, DriverManagerHL DM, int iteration, String name, Repo_WebRepository repo) {
			
		String docu = "132138775";
		String user = "zenziyaFA";
		String pass = "Zenziya2020RD";
		
		//ADD THE STEPS BELOW
		report.AddLine("Se ingresa el documento: " + docu);
		System.out.println("Se ingresa el documento: " + docu);
		repo.get_txtDocumento().sendKeys(docu);
				
		report.AddLine("Se ingresa el usuario: " + user);
		System.out.println("Se ingresa el usuario: " + user);
		repo.get_txtUsername().sendKeys(user);
		
		report.AddLine("Se hace click en el boton Continuar");
		System.out.println("Se hace click en el boton Continuar");
		repo.get_btnContinuar().click();
		
		report.AddLine("Se ingresa el password");
		System.out.println("Se ingresa el password");
		report.Screenshot(name);
		repo.get_txtPassword().sendKeys(pass);
		
		//Agregar espera de elemento
		
		report.AddLine("Se hace click en el boton Continuar");
		System.out.println("Se hace click en el boton Continuar");
		report.Screenshot(name);
		repo.get_btnContinuar().click();
		
		//ADD VALIDATIONS AT THE END
		// ESPERAMOS A QUE CARGUE UN ELEMENTO DEL MENU PARA VALIDAR EL INGRESO	


	}
	
}