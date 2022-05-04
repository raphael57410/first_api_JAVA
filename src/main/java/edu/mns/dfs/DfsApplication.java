package edu.mns.dfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfsApplication.class, args);
	}

}
