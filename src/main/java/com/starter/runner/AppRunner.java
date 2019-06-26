package com.starter.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.starter.document.Employee;
import com.starter.repo.EmployeeRepository;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repo;
	
	public void run(String... args)throws Exception{
		Optional<Employee> opt= repo.findById("123ab");
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("not found");
		}
		
		repo.findAll().forEach(System.out::println);
		
		repo.findAll(Sort.by(Direction.DESC, "empSal")).forEach(System.out::println);
		
		repo.findAll(PageRequest.of(1, 2)).forEach(System.out::println);
	}
	
	
}
