package me.oskarscot.joblistingsite.service;

import java.util.List;
import java.util.Optional;
import me.oskarscot.joblistingsite.model.JobListing;
import me.oskarscot.joblistingsite.repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobListingService {

  private final JobListingRepository repository;

  @Autowired
  public JobListingService(JobListingRepository repository) {
    this.repository = repository;
  }

  public List<JobListing> getAllListings(){
    return this.repository.findAll();
  }

  public Optional<JobListing> getListing(String id){
    return this.repository.findById(id);
  }

  public void addNewListing(JobListing listing){
    this.repository.save(listing);
  }

  public void deleteListing(String id){
    this.repository.deleteById(id);
  }

}
