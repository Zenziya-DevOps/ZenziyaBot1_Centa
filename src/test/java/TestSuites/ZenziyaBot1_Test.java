package TestSuites;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import Tools.DriverManagerHL;
import CentaJava.Core.Reports;
import Repositories.Repo_Variables;
import TestCases.*;

import org.junit.jupiter.api.Tag;

import Tools.msgWorker;
import junit.framework.Assert;

public class ZenziyaBot1_Test 
{
	static 

	//Init
	//DriverManager DM;
	DriverManagerHL DM;
	
	static Datasources data;
	static Reports report;
	static Repo_Variables repoVar;

	@BeforeAll
	static void initAll() {
		//DriverManager
		//DM = new DriverManager();
		DM = new DriverManagerHL();
		//DataSource
		data = new Datasources();
		//Reports
		report = new Reports();
		//Variables Repository
		repoVar = new Repo_Variables();
	}

	@BeforeEach
	void init() {
	}

	@Test
	@Tag("BOT 1")
	void Bot1() {
		//DEFINITIONS
		Acciones_BOT_1 bot1 = new Acciones_BOT_1();
		msgWorker msgWorker = new msgWorker();

		//Inicializacion de las Variables del Repositorio
		repoVar.setTipoTc("WEB");

		//SET INDIVIDUAL DATASOURCE
		data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");
		String name = "BOT 1";
		boolean status = false;
		String msg = "True;Todas las iteraciones resultaron OK";
		int index = 0;

		//for(int x=0;x<data.getTotalIterations();x++) {
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			//status = bot1.Test(data, report, DM, x, name + "_Iteracion_" + x);
			status = bot1.Test(data, report, DM, x, name + "_Iteracion_" + x);
			report.addTestCaseToGeneralReport(status, name + "_Iteracion_" + x, "");
			report.saveTestCaseReport(name + "_Iteracion_" + x);
			//Verificamos si la ejecucion falla y guardamos el status Gral.
			if (status == false)
			{
				msg = msgWorker.msgGen(repoVar, status, x, index);
				index++;
			}
		}
		//Se avisa x jUnit el resultado de la prueba
		Assert.assertEquals("Resultado: " + msg.split(";")[1],"True", msg.split(";")[0]);
	}

	@AfterEach
	void tearDown() {
		if (repoVar.getTipoTc().equals("API")) {
			report.addTestCaseToGeneralReport(repoVar.getResult(), repoVar.getDataStr(), "");
			report.saveTestCaseReport(repoVar.getDataStr());
		} else {
			//System.out.println("El caso de prueba no es: API");
		}
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("Execution finished");
		report.saveGeneralReport();
	}

}

