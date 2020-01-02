package org.sid;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

import org.sid.Dao.AnalyseRepository;
import org.sid.Dao.ClientRepository;
import org.sid.Entities.Analyse;
import org.sid.Entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppGestionAnalysesClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppGestionAnalysesClientApplication.class, args);
	}

	@Bean
	CommandLineRunner start (ClientRepository clientRepository,AnalyseRepository analyseRepository)
	{
		return args->{
			clientRepository.deleteAll();
			Stream.of("C1 Ali","C2 Amine").forEach(c->{
				clientRepository.save(new Client(c.split(" ").clone()[0],"OUZAMOU",c.split(" ").clone()[1],"path", new ArrayList<>()));
				
				});
			clientRepository.findAll().forEach(System.out::println);
			
			Client c1 = clientRepository.findById("C1").get();
			Client c2 = clientRepository.findById("C2").get();

			
			analyseRepository.deleteAll();
			Stream.of("Tete","Main","Dos").forEach(name->{
				Analyse a = analyseRepository.save(new Analyse(null,name,new Date(),Math.random()*1000,true,c1));
				c1.getAnalyses().add(a);
				clientRepository.save(c1);
			});
			
			Stream.of("Lesyeux","Dos").forEach(name->{
				Analyse a = analyseRepository.save(new Analyse(null,name,new Date(),Math.random()*1000,false,c2));
				c2.getAnalyses().add(a);
				clientRepository.save(c2);
			});
			
			analyseRepository.findAll().forEach(System.out::println);
			
		};
	}

}
