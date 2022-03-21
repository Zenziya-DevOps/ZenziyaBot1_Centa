package Tools;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class dbWorkerMySql {

	public int mySqlInsertQuery(String query) throws SQLException
	{		 
		// Credenciales
		String userId = "bot-account-do@prd-efectivoya-do";
		String password = "ugFn5MF+PaVuwY9iIsZ9oBFjW8HrI5ACat15hUTH";
		String dataBase = "prd_efectivo_ya";
		String dataSource = "prd-efectivoya-do.mysql.database.azure.com:3306";

		// CONFIGURACION DEL SSL
		String ssl_ca = "./SSL/BaltimoreCyberTrustRoot.crt.pem";
		String url = String.format("jdbc:mysql://" + dataSource + "/" + dataBase + "?sslmode=require&sslrootcet=" + ssl_ca);

		// CONEXION 
		int rs = 0;
		Connection conn = null; 

		try { 
			System.out.println("###  Iniciando conexión con Base de dato MySql.  ###");

//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, password); 
			System.out.println("Conexión iniciada correctamente. Se procede a la ejecucción del query."); 

			Statement stmt = conn.createStatement(); 

			rs = stmt.executeUpdate(query); 

			if (rs !=0 && !conn.getAutoCommit())
				conn.commit();

			stmt.close(); 
			conn.close();
			System.out.println("###  Conexión finalizada.  ###");

		} catch (Exception e) { 
			e.printStackTrace(); 
			System.out.println("###  Conexión fallida (X) ###"); 
		} finally { 
			// release resource .... 
		}

		return rs;
	}
	
	public String mySqlSelectOneQuery(String query) throws SQLException
	{		 
		// Credenciales
		String userId = "bot-account-do@prd-efectivoya-do";
		String password = "ugFn5MF+PaVuwY9iIsZ9oBFjW8HrI5ACat15hUTH";
		String dataBase = "prd_efectivo_ya";
		String dataSource = "prd-efectivoya-do.mysql.database.azure.com:3306";

		// CONFIGURACION DEL SSL
		String ssl_ca = "./SSL/BaltimoreCyberTrustRoot.crt.pem";
		String url = String.format("jdbc:mysql://" + dataSource + "/" + dataBase + "?sslmode=require&sslrootcet=" + ssl_ca);
		
		// VARIABLES RS
		String resp = "";
		
		// CONEXION 
		Connection conn = null;

		try { 
			System.out.println("###  Iniciando conexión con Base de dato MySql.  ###");

//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, password); 
			System.out.println("Conexión iniciada correctamente. Se procede a la ejecucción del query."); 

			Statement stmt = conn.createStatement(); 

			ResultSet rset=stmt.executeQuery(query);
			System.out.println("-> " + query + " <-");

			while (rset.next())
			{
				resp = rset.getString(1);
			}
			conn.close();
			stmt.close();
			rset.close();
			
			System.out.println("###  Conexión finalizada.  ###");

		} catch (Exception e) { 
			e.printStackTrace(); 
			System.out.println("###  Conexión fallida (X) ###"); 
		} finally { 
			// release resource .... 
		}

		return resp;
	}
	
	public String[] mySqlSelectThreeQuery(String query) throws SQLException
	{		 
		// Credenciales
		String userId = "bot-account-do@prd-efectivoya-do";
		String password = "ugFn5MF+PaVuwY9iIsZ9oBFjW8HrI5ACat15hUTH";
		String dataBase = "prd_efectivo_ya";
		String dataSource = "prd-efectivoya-do.mysql.database.azure.com:3306";

		// CONFIGURACION DEL SSL
		String ssl_ca = "./SSL/BaltimoreCyberTrustRoot.crt.pem";
		String url = String.format("jdbc:mysql://" + dataSource + "/" + dataBase + "?sslmode=require&sslrootcet=" + ssl_ca);
		
		// VARIABLES RS
		String[] resp = new String[3];
		
		// CONEXION 
		Connection conn = null; 

		try { 
			System.out.println("###  Iniciando conexión con Base de dato MySql.  ###");

//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, password); 
			System.out.println("Conexión iniciada correctamente. Se procede a la ejecucción del query."); 

			Statement stmt = conn.createStatement(); 

			ResultSet rset=stmt.executeQuery(query);
			System.out.println("-> " + query + " <-");

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
				resp[2] = rset.getString(3);
			}
			conn.close();
			stmt.close();
			rset.close();
			
			System.out.println("###  Conexión finalizada.  ###");

		} catch (Exception e) { 
			e.printStackTrace(); 
			System.out.println("###  Conexión fallida (X) ###"); 
		} finally { 
			// release resource .... 
		}

		return resp;
	}
	
	public String[] mySqlSelectFiveQuery(String query) throws SQLException
	{		 
		// Credenciales
		String userId = "bot-account-do@prd-efectivoya-do";
		String password = "ugFn5MF+PaVuwY9iIsZ9oBFjW8HrI5ACat15hUTH";
		String dataBase = "prd_efectivo_ya";
		String dataSource = "prd-efectivoya-do.mysql.database.azure.com:3306";

		// CONFIGURACION DEL SSL
		String ssl_ca = "./SSL/BaltimoreCyberTrustRoot.crt.pem";
		String url = String.format("jdbc:mysql://" + dataSource + "/" + dataBase + "?sslmode=require&sslrootcet=" + ssl_ca);
		
		// VARIABLES RS
		String[] resp = new String[5];
		
		// CONEXION 
		Connection conn = null; 

		try { 
			System.out.println("###  Iniciando conexión con Base de dato MySql.  ###");

//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userId, password); 
			System.out.println("Conexión iniciada correctamente. Se procede a la ejecucción del query."); 

			Statement stmt = conn.createStatement(); 

			ResultSet rset=stmt.executeQuery(query);
			System.out.println("-> " + query + " <-");

			while (rset.next())
			{
				resp[0] = rset.getString(1);
				resp[1] = rset.getString(2);
				resp[2] = rset.getString(3);
				resp[3] = rset.getString(4);
				resp[4] = rset.getString(5);
			}
			conn.close();
			stmt.close();
			rset.close();
			
			System.out.println("###  Conexión finalizada.  ###");

		} catch (Exception e) { 
			e.printStackTrace(); 
			System.out.println("###  Conexión fallida (X) ###"); 
		} finally { 
			// release resource .... 
		}

		return resp;
	}
}