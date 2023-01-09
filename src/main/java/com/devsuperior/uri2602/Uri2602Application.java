package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustmoerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

    @Autowired
	private CustomerRepository repository;
	@Override
	public void run(String... args) throws Exception {

		repository.searchByNameWhereState("RS").stream().map(x -> x.getName()).forEach(System.out::println);
		List<CustmoerMinProjection> names = repository.searchByNameWhereState("MG");
		names.stream().map(x -> x.getName()).forEach(System.out::println);

		List<CustomerMinDTO> namesDTO = repository.searchByNameWhereState("RS")
				.stream()
				.map(x -> new CustomerMinDTO(x.getName()))
				.collect(Collectors.toList());

		namesDTO.stream().map(x -> x.getName()).forEach(System.out::println);
		System.out.println("\n\n CONSULTA JPQL \n");
		repository.searchCustomerByName("RS").stream().map(x -> x.getName()).forEach(System.out::println);
	}
}
