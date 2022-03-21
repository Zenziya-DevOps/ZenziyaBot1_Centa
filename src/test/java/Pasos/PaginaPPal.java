package Pasos;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_WebRepository;
import Tools.DriverManagerHL;

public class PaginaPPal {
	WebDriver driver;

	public String accionesFlow (Datasources data,Reports report, DriverManagerHL DM, int iteration, String name, Repo_WebRepository repo, String nroDop) throws InterruptedException, SQLException {

		// Variables
		boolean cuentaValida = false;
		String dataFront = "";

		//SWITCH TO CORRECT IFRAME
		switchToFrame(DM, repo);

		//ADD THE STEPS BELOW
		report.AddLine("Se selecciona tipo de Cta de Origen");
		System.out.println("Se selecciona  tipo de Cta de Origen");
		repo.get_cboCtaOrigen().click(); //combo
		Thread.sleep(500);
		repo.get_itemCboCtaOrigen().click(); //item

		Thread.sleep(1000);

		report.AddLine("Se selecciona tipo de Cta Destino");
		System.out.println("Se selecciona tipo de Cta Destino");
		repo.get_cboCtaDestino().click(); //combo
		Thread.sleep(500);
		repo.get_itemCboCtaDestino("Cuenta de ahorro").click(); //item
		
		report.AddLine("Se ingresa el Nro. DOP: "+nroDop);
		System.out.println("Se ingresa el Nro. DOP: "+nroDop);
		repo.get_txtDOP().sendKeys(nroDop);
		Thread.sleep(500);

		report.AddLine("Se ingresa el monto");
		System.out.println("Se ingresa el monto");
		repo.get_txtMonto().sendKeys("1");
		Thread.sleep(500);
		
		report.AddLine("Se hace click en el boton Continuar");
		System.out.println("Se hace click en el boton Continuar");
		repo.get_btnSiguiente().click();
		
		Thread.sleep(1000);
		
		// El metodo detectErrors verifica que no se encuentren visibles lbls de error.
		if (detectErrors(DM, repo, report).equals("")) {
			// Extraemos y asignamos el texto del campo donde se encuentra el nombre 
			dataFront = repo.get_inputVerifNombre().getText();
			System.out.println("Cuenta de ahorro valida. Nombre Cuenta extraido: " + dataFront+" \r\n");
			report.AddLine("Cuenta de ahorro valida. Nombre Cuenta extraido: " + dataFront+" \r\n");
			
		// En caso de detectar un error procedemos a intentar cargar el mismo numero pero en una cuenta corriente.
		} else {
			report.AddLine("El usuario no tiene una Cuenta de ahorro asosiada. Se selecciona Cuenta corriente");
			System.out.println("El usuario no tiene una Cuenta de ahorro asosiada. Se selecciona Cuenta corriente  \r\n");

			report.AddLine("Se selecciona tipo de Cta Destino");
			System.out.println("Se selecciona tipo de Cta Destino");
			repo.get_cboCtaDestino().click(); //combo
			Thread.sleep(500);
			repo.get_itemCboCtaDestino("Cuenta corriente").click(); //item

			report.AddLine("Se ingresa el Nro. DOP: "+nroDop);
			System.out.println("Se ingresa el Nro. DOP: "+nroDop);
			repo.get_txtDOP().clear();
			Thread.sleep(500);
			repo.get_txtDOP().sendKeys(nroDop);

			report.AddLine("Se ingresa el monto");
			System.out.println("Se ingresa el monto");
			repo.get_txtMonto().clear();
			Thread.sleep(500);
			repo.get_txtMonto().sendKeys("1");
			Thread.sleep(500);
			
			report.AddLine("Se hace click en el boton Continuar");
			System.out.println("Se hace click en el boton Continuar");
			repo.get_btnSiguiente().click();
			
			Thread.sleep(1000);
			
			// El metodo detectErrors verifica que no se encuentren visibles lbls de error.
			if (detectErrors(DM, repo, report).equals("")) {
				
				// Extraemos y asignamos el texto del campo donde se encuentra el nombre
				dataFront= repo.get_inputVerifNombre().getText();
				System.out.println("Cuenta Corriente valida. Nombre Cuenta extraido: " + dataFront+" \r\n");
				report.AddLine("Cuenta Corriente valida. Nombre Cuenta extraido: " + dataFront+" \r\n");
			} else {
				System.out.println("El usuario no tiene cuentas a asosiadas \r\n");
				report.AddLine("El usuario no tiene cuentas a asosiadas \r\n");
				// Como no tiene cuenta corriente, ni cuenta de ahorro, se asigna el error del front
				dataFront = detectErrors(DM, repo, report);			
			}
		}

		report.Screenshot(name);

		return dataFront;
	}

	private void switchToFrame (DriverManagerHL DM, Repo_WebRepository repo) {

		driver = DM.getActualDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(repo.get_MainIframe());

	}
	
	private String detectErrors (DriverManagerHL DM, Repo_WebRepository repo, Reports report) throws InterruptedException {
		
		String error = "";
		
		Thread.sleep(1000);
		
		// Se determinan los errores posibles de tipo 1
		report.AddLine("Inicia la validacion de errores del frontend...");
		System.out.println("Inicia la validacion de errores del frontend...");
		boolean error1 = true;
		
		Thread.sleep(100);
		try {
			repo.get_lblError().click();
			error1 = true;
		} catch (Exception e) {
			error1 = false;
		}	
		
		// Depende de la visibilidad del elemento error extraemos el dato
		if (error1) {
			Thread.sleep(500);
			error = repo.get_lblError().getText();
		}
		
		// Se determinan los errores posibles de tipo 2
		boolean error2 = true;
		
		Thread.sleep(100);
		try {
			repo.get_lblError2().click();
			error2 = true;
		} catch (Exception e) {
			error2 = false;
		}	
		
		// Depende de la visibilidad del elemento error extraemos el dato
		if (error2) {
			Thread.sleep(500);
			error = repo.get_lblError2().getText();
		}
		
		if (error.equals("")) {
			report.AddLine("No se detectan errores de validacion en el frontend");
			System.out.println("No se detectan errores de validacion en el frontend");
			
			report.AddLine("Finaliza la validacion de errores del frontend.");
			System.out.println("Finaliza la validacion de errores del frontend.");
			// Si no hay errores se devuelve un string vacio.
			return "";
			
		} else {
			report.AddLine("El error no permitio procesar la solicitud. Errores detectados: "+error);
			System.out.println("El error no permitio procesar la solicitud. Errores detectados: "+error);
			return error;
		}	
	}

}