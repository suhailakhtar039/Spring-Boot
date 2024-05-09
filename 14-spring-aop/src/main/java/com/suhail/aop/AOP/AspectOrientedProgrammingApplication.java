package com.suhail.aop.AOP;

import com.suhail.aop.AOP.dao.AccountDAO;
import com.suhail.aop.AOP.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner->{
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoTheAfterAdvice(accountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain program: demoTheAfterAdvice");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("Demo");
		account.setLevel("4");

		accountDAO.addAccount(account, true);
		membershipDAO.addAccount();

		// call the account getter/setter
		accountDAO.setName("Suhail");
		accountDAO.setServiceCode("Silver");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
	}

}
