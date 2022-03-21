package Tools;

import java.sql.*;
import oracle.jdbc.OracleResultSetMetaData;

public class dbWorker {
	
	// DB WORKER CON CADENA DE CONEXION DE ENTIDAD 8118 QA
	public String oraOneQuery(String Query, String colName) throws SQLException
	{
		//Variables
		String resp = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB ONE SELECT ENTIDAD 8118<-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022"); //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(Query);

			while (rset.next())
			{
				//int index = rs.findColumn(colName);
				resp = rset.getString(colName);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}		
		System.out.println("-> Connection Close ONE SELECT ENTIDAD 8118 <-\r\n");

		return resp;
	}

	public String oraOneQuery(String Query) throws SQLException
	{
		//Variables
		String resp = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB ONE SELECT ENTIDAD 8118 QA <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			System.out.println("-> " + Query + " <-");
			ResultSet rset=stmt.executeQuery(Query);

			while (rset.next())
			{
				resp = rset.getString(1);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close ONE SELECT ENTIDAD 8118 QA <-\r\n");

		return resp;
	}

	public String[] oraTwoQuery(String Query) throws SQLException
	{
		//Variables
		String[] resp = new String[2];
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB TWO SELECT ENTIDAD 8118 <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			System.out.println("-> " + Query + " <-");
			ResultSet rset=stmt.executeQuery(Query);

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close TWO SELECT ENTIDAD 8118 <-\r\n");

		return resp;
	}

	public String[] oraThreeQuery(String Query) throws SQLException
	{
		//Variables
		String[] resp = new String[3];
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB THREE SELECT ENTIDAD 8118 - QA<-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			System.out.println("-> " + Query + " <-");
			ResultSet rset=stmt.executeQuery(Query);

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
				resp[2] = rset.getString(3);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close THREE SELECT ENTIDAD 8118 - QA<-\r\n");

		return resp;
	}
	
	public String[] oraFourQuery(String Query) throws SQLException
	{
		//Variables
		String[] resp = new String[4];
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB FOUR SELECT ENTIDAD 8118 <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(Query);
			System.out.println("-> " + Query + " <-");

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
				resp[2] = rset.getString(3);
				resp[3] = rset.getString(4);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close FOUR SELECT ENTIDAD 8118 <-\r\n");

		return resp;
	}

	public String oraQueryCsv(String Query) throws SQLException
	{
		//Variables
		String resp = "";
		String header = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";
		int idx = 0;

		try {
			System.out.println("-> Connecting to DB <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(Query);
			OracleResultSetMetaData rsmd = (OracleResultSetMetaData)rset.getMetaData();

			int colCount = rsmd.getColumnCount();

			for (int x = 1; x <= colCount; x++) 
			{	
				header = header + rsmd.getColumnName(x) + ",";
			}

			while (rset.next())
			{
				if (idx != 0)
				{
					resp = resp + "\r\n";
				} else {
					resp = createHeader(header) + "\r\n";
				}
				resp = resp + rset.getString(header.split(",")[0]) + "," +  rset.getString(header.split(",")[1])  + "," + rset.getString(header.split(",")[2]);
				idx++;
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close <-");

		return resp;
	}

	public int oraInsert (String sqlInsert) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB INSERT ESQUEMA 8118 <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt = conn.createStatement();

			rows = stmt.executeUpdate(sqlInsert);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (rows !=0 && !conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close INSERT ESQUEMA 8118 <-\r\n");

		return rows;
	}
	
	public int oraUpdate (String sqlUpdate) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB UPDATE ESQUEMA 8118 QA <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt = conn.createStatement();
			System.out.println("-> " + sqlUpdate + " <-");
			rows = stmt.executeUpdate(sqlUpdate);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (rows !=0 && !conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close DB UPDATE ESQUEMA 8118 QA <-\r\n");

		return rows;
	}

	public int oraDelete (String sqlDelete) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB DB DELETE ESQUEMA 8118 <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt = conn.createStatement();
			System.out.println("-> " + sqlDelete + " <-");
			rows = stmt.executeUpdate(sqlDelete);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (!conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close DELETE ESQUEMA 8118 <-\r\n");

		return rows;
	}

	public boolean oraBorrarCuenta (String id_cuenta, String doc) {
		//Variables
		boolean RES = false;
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB - Eliminacion de cuenta - ESQUEMA 8118 QA <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt = conn.createStatement();

			int[] results = new int[13];
			results[0] = stmt.executeUpdate("delete tarjetas_historial where id_tarjeta = (select id_tarjeta from tarjetas where id_cuenta = " + id_cuenta + ")");
			results[1] = stmt.executeUpdate("delete tarjetas_nov where id_tarjeta = (select id_tarjeta from tarjetas where id_cuenta = " + id_cuenta + ")");
			results[2] = stmt.executeUpdate("delete socios_nov where id_cuenta = " + id_cuenta);
			results[3] = stmt.executeUpdate("delete personas_nov where id_persona = (select id_persona from personas where nro_documento = " + doc + ")");
			results[4] = stmt.executeUpdate("update socios set id_tarjeta_vigente = null where id_cuenta = " + id_cuenta);
			results[5] = stmt.executeUpdate("delete tarjetas where id_cuenta = " + id_cuenta + " and ID_ADICIONAL = 0");
			results[6] = stmt.executeUpdate("update socios set id_persona = 1 where id_cuenta = " + id_cuenta);
			results[7] = stmt.executeUpdate("delete personas where nro_documento = " + doc);
			results[8] = stmt.executeUpdate("delete socios where id_cuenta = " + id_cuenta + " and ID_ADICIONAL = 0");
			results[9] = stmt.executeUpdate("delete cuentas_moneda where id_cuenta = " + id_cuenta);
			results[10] = stmt.executeUpdate("delete cuentas where id_cuenta = " + id_cuenta);
			results[11] = stmt.executeUpdate("delete cuentas_moneda_auditoria where id_cuenta = " + id_cuenta);
			results[12] = stmt.executeUpdate("delete socios_nov where id_cuenta = " + id_cuenta);

			//SE RECORREN LOS RESULTADOS PARA VALIDAR LAS RESPUESTAS
			for (int i = 0; i<results.length; i++) {
				if (results[i] == 0) {
					RES = false;
					System.out.println("Falló: " + Integer.valueOf(i) + "\r\nResultado: " + results[i]);
					break;
				} else {
					RES = true;
				}
			}


			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (RES && !conn.getAutoCommit())
				conn.commit();

			//SE CIERRAN LAS CONEXIONES
			stmt.close();
			conn.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("oraBorraId Error: " + e);
		}

		System.out.println("-> Connection Close - ESQUEMA 8118 QA <-\r\n");

		return RES;
	}

	public String oraValidaAlta (String doc) {
		//Variables
		String resp = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB Validacion Alta de Cuenta - ESQUEMA 8118 QA <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select c.id_cuenta NRO_CUENTA_CREADA\r\n"
					+ "		from personas p\r\n"
					+ "		inner join socios s on s.id_persona = p.id_persona\r\n"
					+ "		inner join cuentas c on s.id_cuenta = c.id_cuenta\r\n"
					+ "		inner join tarjetas t on c.id_cuenta = t.id_cuenta\r\n"
					+ "		inner join tarjetas_historial th on th.id_tarjeta = t.id_tarjeta\r\n"
					+ "		where p.nro_documento = " + doc);

			while (rset.next())
			{
				resp = rset.getString(1);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("oraValidaAlta Error: " + e);
		}
		System.out.println("-> Connection Close - ESQUEMA 8118 QA <-\r\n");

		return resp;

	}

	public String oraValidaTipoTarjeta (String id_cuenta) {
		//Variables
		String resp = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@gpdbqans.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/GP247";

		try {
			System.out.println("-> Connecting to DB Validacion Tipo de Tarjeta - ESQUEMA 8118 QA <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_entidad8118","int_entidad2022");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("SELECT SOPORTE_FISICO FROM TARJETAS WHERE ID_CUENTA = " + id_cuenta);

			while (rset.next())
			{
				resp = rset.getString(1);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("oraValidaAlta Error: " + e);
		}
		System.out.println("-> Connection Close - ESQUEMA 8118 QA <-\r\n");

		return resp;

	}
	
	private String createHeader(String header)
	{
		return header.substring(0, header.length()-1);
	}
	
	
	// DB WORKER CON CADENA DE CONEXION DE PARAM	
	public int oraDeleteParam (String sqlDelete) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@parametria-qa.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/PARAMQA";

		try {
			System.out.println("-> Connecting to DB DELETE QA PARAM <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_param","Para_CoNs#sp");
			Statement stmt = conn.createStatement();
			System.out.println("-> " + sqlDelete + " <-");
			rows = stmt.executeUpdate(sqlDelete);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (!conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close DELETE QA PARAM <-\r\n");

		return rows;
	}
	
	public int oraInsertParam (String sqlInsert) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@parametria-qa.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/PARAMQA";

		try {
			System.out.println("-> Connecting to DB INSERT QA PARAM <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_param","Para_CoNs#sp");
			Statement stmt = conn.createStatement();

			rows = stmt.executeUpdate(sqlInsert);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (rows !=0 && !conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close INSERT QA PARAM <-\r\n");

		return rows;
	}

	public int oraUpdateParam (String sqlUpdate) {
		//Variables
		int rows = 0;
		String strCon = "jdbc:oracle:thin:@parametria-qa.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/PARAMQA";

		try {
			System.out.println("-> Connecting to DB UPDATE QA PARAM <-");
			Connection conn = DriverManager.getConnection(strCon,"qa_param","Para_CoNs");
			Statement stmt = conn.createStatement();

			rows = stmt.executeUpdate(sqlUpdate);

			//SI EL RESULTADO ES OK Y LA BASE NO TIENE AUTOCOMMIT... 
			if (rows !=0 && !conn.getAutoCommit())
				conn.commit();

			conn.close();
			stmt.close();

			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("-> Connection Close UPDATE QA PARAM<-\r\n");

		return rows;
	}
	
	public String oraOneQueryParam(String Query) throws SQLException
	{
		//Variables
		String resp = "";
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@parametria-qa.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/PARAMQA";

		try {
			System.out.println("-> Connecting to DB <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_param","Para_CoNs#sp");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(Query);

			while (rset.next())
			{
				resp = rset.getString(1);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close <-");

		return resp;
	}
	
	public String[] oraTwoQueryParam(String Query) throws SQLException
	{
		//Variables
		String[] resp = new String[2];
		//String strCon = "jdbc:oracle:thin:@databasepc:1521/xepdb1"; //"jdbc:oracle:thin:@localhost:1521:xe","hr","hrpass"
		String strCon = "jdbc:oracle:thin:@parametria-qa.cvhla41mhkl1.us-east-1.rds.amazonaws.com:1521/PARAMQA";

		try {
			System.out.println("-> Connecting to DB <-");
			//Connection conn = DriverManager.getConnection(strCon,"hr","hrpass");
			Connection conn = DriverManager.getConnection(strCon,"qa_param","Para_CoNs#sp");
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(Query);

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
			}
			conn.close();
			stmt.close();
			rset.close();
			System.out.println("-> Finished <-");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("-> Connection Close <-");

		return resp;
	}
	
}
