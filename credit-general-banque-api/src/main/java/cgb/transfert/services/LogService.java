package cgb.transfert.services;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cgb.transfert.Etat;
import cgb.transfert.entity.Account;
import cgb.transfert.entity.Log;
import cgb.transfert.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;

	@GetMapping
	public void saveLog(Log unlog) {
		Log logger = new Log(Etat.FAILURE, "Save raté", LocalDate.now(), this.getClass().getSimpleName());

		if (logRepository.save(unlog) != null) {
			logger = new Log(Etat.SUCCESS, "Save effectué", LocalDate.now(), this.getClass().getSimpleName());
		}
		logRepository.save(logger);

	}
	
	@GetMapping
	public void makeJsonLog() {
	      JSONObject jsonObject = new JSONObject();
	      JSONArray logsArray = new JSONArray();
	      
	      for (Log unLog : logRepository.findAll()) {
	          JSONObject logJson = new JSONObject();
	          logJson.put("etatlog", unLog.getEtatlog().toString());
	          logJson.put("description", unLog.getDescription());
	          logJson.put("date", unLog.getDate().toString());
	          logJson.put("nomClass", unLog.getClass1());          
	          logsArray.add(logJson);
	      }
	      jsonObject.put("logs", logsArray); 

	      try {
	         FileWriter file = new FileWriter("C:\\Users\\dylan.ait-eldjoudi\\Documents\\jsonCGB\\cgbLogs.json");
	         
	         Gson gson = new GsonBuilder().setPrettyPrinting().create();
	         String pretty = gson.toJson(jsonObject);
	         file.write(pretty);
	         file.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      System.out.println("JSON  : "+jsonObject);
	}
}
