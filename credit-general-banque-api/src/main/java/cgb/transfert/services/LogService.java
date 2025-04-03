package cgb.transfert.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import cgb.transfert.dto.Etat;
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
}
