package TestCases;

import org.openqa.selenium.WebDriver;


import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Pasos.LogOut;
import Pasos.Login;
import Pasos.MenuLateral;
import Pasos.PaginaPPal;
import Repositories.Repo_WebRepository;
import Tools.DriverManagerHL;
import Tools.dbWorkerMySql;
import junit.framework.Assert;
import Tools.JsonWorker;

public class Acciones_BOT_1 {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManagerHL dM, int iteration,String name) {
		//public boolean Test(Datasources data,Reports report, DriverManager dM, int iteration,String name) {	
		//validation 
		boolean result = true;
		try {

			// Variables
			String extractQuery = "";
			String insertQuery = "";
			String response_result = "";
			String nroDop = "";
			String[] datosEntrada = new String[3];
			String dataFront = "";

			System.out.println("Configuring");

			//SELECT THE DRIVER AND PATH
			//driver = dM.CreateDriver(dM.CHROME);
			driver = dM.createDriver(true);
			report.SetDriver(driver);

			//SET THE REPOSITORIES TO USE
			Repo_WebRepository repo = new Repo_WebRepository();
			repo.setDriver(driver);

			//SET STEPS INSTANCES
			dbWorkerMySql dbWorker = new dbWorkerMySql();
			Login acceso = new Login();
			MenuLateral menuIz = new MenuLateral();
			PaginaPPal pagPPal = new PaginaPPal();
			LogOut salir = new LogOut();
			JsonWorker jw = new JsonWorker();

			
			System.out.println("------ Inicio extraccion del dato en la BDD ------\r\n");
			report.AddLine("------ Inicio extraccion del dato en la BDD ------\r\n");
			
			
			// Buscamos el primer registro a procesar
			extractQuery = "SELECT account_number, id, full_name\r\n"
					+ "FROM bot_account_validation_logs b1\r\n"
					+ "WHERE not exists  (SELECT request_id FROM bot_account_validation_logs where request_id = b1.id)\r\n"
					+ "AND event = 'REQUEST'";

			// Extraemos toda la informacion de la consulta a bot_account_validation_log y asigna al arreglo datosEntrada
			datosEntrada = dbWorker.mySqlSelectThreeQuery(extractQuery);
			
			System.out.println("------ Fin extraccion del dato en la BDD ------\r\n");
			report.AddLine("------ Fin extraccion del dato en la BDD ------\r\n");
			
			
			// Asignamos el datoEntrada que corresponde a account_number en nroDop para usarlo en el frontend
			nroDop = datosEntrada[0];
			
			// Si el nroDop es null la query no tiene datos encontrados
			if (nroDop==null) {				
				
				System.out.println("El resultado de la query no devolvio datos a procesar.");
				report.AddLine("El resultado de la query no devolvio datos a procesar.");
			
			} else {
				
				//WEB STEPS
				System.out.println("------ Initializating: " + name + " ------\r\n");
		
				System.out.println("------ Inicia navegacion en el frontend ------\r\n");
				report.AddLine("------ Inicia navegacion en el frontend ------\r\n");
				
				System.out.println("DOP a procesar: "+nroDop);
				report.AddLine("DOP a procesar: "+nroDop);
				
				//SET THE URL
				driver.get("https://www.banreservas.com.do/TuBancoEmpresas/Login.aspx");

				//ADD THE STEPS BELOW
				//LOGIN
				acceso.logIn(data, report, dM, iteration, name, repo);

				//NAVEGACION A TRANSFERENCIAS
				menuIz.menuTransferencias(data, report, dM, iteration, name, repo);

				//SELECCION DE LA OPERACION
				menuIz.menuTerceros(data, report, dM, iteration, name, repo);

				//ACCIONES
				dataFront = pagPPal.accionesFlow(data, report, dM, iteration, name, repo, nroDop);
				
				//CERRAR SESION
				salir.logOut(data, report, dM, iteration, name, repo);
				
				System.out.println("------ Fin de la navegacion en el frontend ------\r\n");
				report.AddLine("------ Fin de la navegacion en el frontend ------\r\n");
				
				System.out.println("------ Inicio del grabado en la base de datos ------\r\n");
				report.AddLine("------ Inicio del grabado en la base de datos ------\r\n");
				
				// Extraemos el dato desde el frontend para el armado de la query de insert
				response_result = dataFront;

				System.out.println("Response result: "+response_result);
				report.AddLine("Response result: "+response_result);

				//El request_id tiene que ser el mismo id que el recibido en el REQUEST, osea datosEntrada[0].
				insertQuery = "INSERT INTO `bot_account_validation_logs` ( `id_number`, `full_name`, `country`, `bank_name`, `account_number`, `response_result`, `request_id`, `event`) \r\n"
						+ "VALUES ('00001', '"+datosEntrada[2]+"','DO', 'Some Bank', '"+datosEntrada[0]+"', '" +response_result+ "', '"+String.valueOf(datosEntrada[1])+"','RESPONSE')";

				
				//Validacion y ejecuccion de la consulta
				if (dbWorker.mySqlInsertQuery(insertQuery) >= 1) {
					report.AddLine("Ejecucion correcta del insert en la BDD");
					System.out.println("Ejecucion correcta del insert en la BDD");
					
					report.AddLine("Inicia la creacion del archivo Json");
					System.out.println("Inicia la creacion del archivo Json");
					jw.crearJson(datosEntrada, response_result);
				}
				
				System.out.println("------ Fin del grabado en la base de datos ------\r\n");
				report.AddLine("------ Fin del grabado en la base de datos ------\r\n");
				
				System.out.println("\r\n------ Finished: " + name + " ------\r\n");
			}

		} catch(Exception e) {
			e.printStackTrace();
			report.AddLineAssertionError(e.getMessage());			
			result = false;
		}
		//Try to erase the driver
		try {
			driver.quit();
		} catch(Exception e2) {
			//return the test result
		}

		return result;
	}

	private void WaitTime(int i) {
		try
		{
			Thread.sleep(i);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	} 
}