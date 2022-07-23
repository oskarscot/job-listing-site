package me.oskarscot.joblistingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class JobListingSiteApplication {

  public static void main(String[] args) {
    SpringApplication.run(JobListingSiteApplication.class, args);
  }

}
