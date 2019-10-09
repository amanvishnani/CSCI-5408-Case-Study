package ca.dal.casestudy1;

import ca.dal.casestudy1.repository.DataRepository;
import ca.dal.casestudy1.repository.MongoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackageClasses = DataRepository.class)
@EnableMongoRepositories(basePackageClasses = MongoDataRepository.class)
@SpringBootApplication
public class CaseStudy1Application {

	public static void main(String[] args) {
		SpringApplication.run(CaseStudy1Application.class, args);
	}

}
