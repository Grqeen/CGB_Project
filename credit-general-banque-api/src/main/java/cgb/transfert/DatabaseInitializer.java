package cgb.transfert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cgb.transfert.entity.Account;
import cgb.transfert.entity.Customer;
import cgb.transfert.entity.User;
import cgb.transfert.repository.AccountRepository;
import cgb.transfert.services.CustomerService;
import cgb.transfert.services.IbanGenerator;
import cgb.transfert.services.MyUserDetailsService;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

	@Autowired
	private AccountRepository accountRepository;

	private final MyUserDetailsService userService;

	private final CustomerService cs;

	@Autowired
	public DatabaseInitializer(MyUserDetailsService userService, CustomerService cs) {
		this.userService = userService;
		this.cs = cs;
	}

	@PostConstruct
	public void init() {
		// Vérifiez si la base de données est vide avant d'insérer des données
		if (accountRepository.count() == 0) {
			insertSampleData(accountRepository);
		}
		if (userService.count() == 0) {
			// Appeler une méthode qui crée un jeu d’exemple et qui les sauvegarde
			// par le biais du repository
			initUser(userService, cs);
		}
	}

	public static void insertSampleData(AccountRepository accountRepository) {
		// Insérer des comptes d'exemple
		for (int i = 0; i < 20; i++) {
			Account account = new Account();
			IbanGenerator ibanGenerator = new IbanGenerator();
			account.setAccountNumber(ibanGenerator.generateValidIban());
			account.setSolde(300.00 + (i * 100.00));
			accountRepository.save(account);
		}

		Account account2 = new Account();
		account2.setAccountNumber("FR7630001007941234567890185");
		account2.setSolde(60000.00);
		accountRepository.save(account2);

		Account account3 = new Account();
		account3.setAccountNumber("FR7630004000031234567890143");
		account3.setSolde(90000.00);
		accountRepository.save(account3);

		Account account4 = new Account();
		account4.setAccountNumber("FR7630056009271234567890182");
		account4.setSolde(8000.00);
		accountRepository.save(account4);

	}

	public void initUser(MyUserDetailsService us, CustomerService cs) {

		Customer c1 = new Customer();
		c1.setName("Evian");
		c1 = cs.save(c1);

		User u1 = new User();
		u1.setUsername("Hubble");
		u1.setPassword("password");
		u1.setRole(Role.ADMIN);
		u1.setCustomer(c1);

		Customer c2 = new Customer();
		c2.setName("Volvic");
		c2 = cs.save(c2);

		User u2 = new User();
		u2.setUsername("user");
		u2.setPassword("password");
		u2.setRole(Role.USER);
		u2.setCustomer(c2);

		Customer c3 = new Customer();
		c3.setName("Perrier");
		c3 = cs.save(c3);

		User u3 = new User();
		u3.setUsername("root");
		u3.setPassword("root");
		u3.setRole(Role.ADMIN);
		u3.setCustomer(c3);
		
		Customer c4 = new Customer();
		c4.setName("Vitel");
		c4 = cs.save(c4);

		User u4 = new User();
		u4.setUsername("comptable");
		u4.setPassword("password");
		u4.setRole(Role.COMPTABLE);
		u4.setCustomer(c4);

		us.registerUser(u1);
		us.registerUser(u2);
		us.registerUser(u3);
		us.registerUser(u4);
	}

}
