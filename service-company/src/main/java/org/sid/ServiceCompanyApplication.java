package org.sid;

import java.util.stream.Stream;

import org.sid.dao.CompanyRepository;
import org.sid.entities.company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//	}
	@Bean
	CommandLineRunner start(CompanyRepository companyRepository) {
		return args -> {
			Stream.of("societe A"," societe B"," societe C").forEach(companyName-> {
				companyRepository.save(new company(null, companyName,100+Math.random()*900 ));
			});
			
			companyRepository.findAll().forEach(System.out::println);
			
		};
	}

}
