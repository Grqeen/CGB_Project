package cgb.transfert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgb.transfert.services.LogService;
import cgb.transfert.services.Utilitaire;


@RestController
@RequestMapping("/makeLogs")
public class LogController {
	@Autowired
	private LogService logService;	
	
	@GetMapping("/all")
	public ResponseEntity<String> obtenirTache() {

		logService.makeJsonLog();
	    return new ResponseEntity(HttpStatus.OK);

	}

}

