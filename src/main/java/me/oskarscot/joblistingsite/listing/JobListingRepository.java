package me.oskarscot.joblistingsite.listing;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListingRepository extends MongoRepository<JobListing, String> {

  public Optional<JobListing> findById(String id);
  public List<JobListing> findByEmployer(String employer);
  public List<JobListing> findByLocation(String location);
  public List<JobListing> findByJobType(String jobType);
  public List<JobListing> findByPostedAfter(Instant postedAfter);
  public List<JobListing> findByPostedBefore(Instant postedBefore);
  public List<JobListing> findByName(String name);
}
