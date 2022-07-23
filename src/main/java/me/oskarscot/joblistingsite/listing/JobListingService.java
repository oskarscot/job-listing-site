package me.oskarscot.joblistingsite.listing;

import java.util.List;
import me.oskarscot.joblistingsite.exception.ListingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobListingService {

  private final JobListingRepository repository;

  @Autowired
  public JobListingService(JobListingRepository repository) {
    this.repository = repository;
  }

  public List<JobListing> getAll() {
    return repository.findAll();
  }

  public void addNewListing(JobListing listing){

    repository.save(listing);
  }

  public void deleteListing(String id) {
    repository.findById(id).ifPresentOrElse(repository::delete, () -> {
      throw new ListingNotFoundException("No listing found with id: " + id);
    });
  }

  public JobListing getById(String id) {
    return repository.findById(id).orElseThrow(() -> new ListingNotFoundException("No listing found with id: " + id));
  }
}
