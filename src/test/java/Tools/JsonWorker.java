package Tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonWorker {
	
	
	public void crearJson(String[] datosEntrada, String RR) {
		
		System.out.println("### JsonWorker - Se inicia la creacion del archivo JSON ###");
		
		// Creacion de json report
		new File("./JsonReports/").mkdirs();
		
		// Instancias
		JSONObject datosJsonObj = new JSONObject();
		

        // Creamos y formateamos la fecha y la hora 
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fechaFormateada = fecha.format(LocalDateTime.now()).replace("/", "-").replace(":", "").replace(" ", "_");

        // Creamos el path del archivo con el documento y la fecha del sistema
        String path = "./JsonReports/" +datosEntrada[0]+ "_" +fechaFormateada+".json";
        

		datosJsonObj.put("id_number", "00001");
		datosJsonObj.put("full_name", datosEntrada[2]);
		datosJsonObj.put("country", "DO");
		datosJsonObj.put("bank_name", "Some bank");
		datosJsonObj.put("account_number", datosEntrada[0]);
		datosJsonObj.put("response_result", RR);
		datosJsonObj.put("request_id", datosEntrada[1]);
		datosJsonObj.put("event", "RESPONSE");
		
		// Grabamos el archivo 
		  try {
			  
		      FileWriter file = new FileWriter(path);
		      file.write(datosJsonObj.toJSONString());
		      file.close();
		      System.out.println("Ruta archivo generado: "+path);
		      
		  } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      System.out.println("Error al grabar el archivo JSON");
		  }
		
		  
		
	}	
	
}
