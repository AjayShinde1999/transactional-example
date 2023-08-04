package com.transactionalexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalExampleApplication.class, args);
	}

}
