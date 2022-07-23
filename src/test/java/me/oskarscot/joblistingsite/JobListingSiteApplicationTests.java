package me.oskarscot.joblistingsite;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import me.oskarscot.joblistingsite.listing.JobListing;
import me.oskarscot.joblistingsite.listing.JobListingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobListingSiteApplicationTests {

  @Autowired
  private JobListingRepository repository;

  private JobListing stockholm, glasgow;

  @BeforeEach
  void setup() {

    repository.deleteAll();

    stockholm = repository.save(new JobListing(
        "Java Developer",
        "Description of Java Developer",
        10.0,
        "Full Time",
        "Stockholm",
        "Google",
        Instant.now())
    );
    glasgow = repository.save(new JobListing(
        "Java Developer",
        "Description of Java Developer",
        10.0,
        "Full Time",
        "Glasgow",
        "Google",
        Instant.now())
    );

    System.out.println("Time: " + glasgow.getPosted().toString());
  }

  @Test
  void testFindAll() {
    for (JobListing jobListing : repository.findAll()) {
      assertThat(jobListing.getId()).isNotNull();
    }
  }

  @Test
  void testFindByLocation() {
    assertThat(repository.findByLocation("Stockholm")).hasSize(1);
    assertThat(repository.findByLocation("Glasgow")).hasSize(1);
  }

  @Test
  void testFindByLocationNotFound() {
    assertThat(repository.findByLocation("Oslo")).isEmpty();
  }

  @Test
  void testFindByLocationNull() {
    assertThat(repository.findByLocation(null)).isEmpty();
  }

  @Test
  void testFindByEmployer() {
    assertThat(repository.findByEmployer("Google")).hasSize(2);
  }

  @Test
  void testFindByJobType(){
    assertThat(repository.findByJobType("Full Time")).hasSize(2);
  }

  @Test
  void testFindByPostedAfter(){
    assertThat(repository.findByPostedAfter(Instant.now().minus(5, ChronoUnit.SECONDS))).hasSize(2);
  }

  @Test
  void testFindByPostedBefore(){
    assertThat(repository.findByPostedBefore(Instant.now().plus(5, ChronoUnit.SECONDS))).hasSize(2);
  }

  @Test
  void testFindByName(){
    assertThat(repository.findByName("Java Developer")).hasSize(2);
  }

}
