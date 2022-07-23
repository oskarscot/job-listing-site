package me.oskarscot.joblistingsite.listing;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/listing")
public class JobListingController {

  private final JobListingService jobListingService;

  @Autowired
  public JobListingController(JobListingService jobListingService) {
    this.jobListingService = jobListingService;
  }

  @GetMapping
  public List<JobListing> getAll() {
    return jobListingService.getAll();
  }

  @GetMapping("{id}")
  public JobListing getById(@PathVariable("id") String id) {
    return jobListingService.getById(id);
  }

  @PostMapping
  public void addNewListing(@RequestBody JobListing listing){
    jobListingService.addNewListing(listing);
  }

  @DeleteMapping(path = "{listingId}")
  public void deleteListing(@PathVariable("listingId") String id){
    jobListingService.deleteListing(id);
  }

}
