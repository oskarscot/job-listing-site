package me.oskarscot.joblistingsite.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import me.oskarscot.joblistingsite.model.JobListing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListingRepository extends MongoRepository<JobListing, String> {

  Optional<JobListing> findById(String id);
  List<JobListing> findByEmployer(String employer);
  List<JobListing> findByLocation(String location);
  List<JobListing> findByJobType(String jobType);
  List<JobListing> findByPostedAfter(Instant postedAfter);
  List<JobListing> findByPostedBefore(Instant postedBefore);
  List<JobListing> findByName(String name);
}
