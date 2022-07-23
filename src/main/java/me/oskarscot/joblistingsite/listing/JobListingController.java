package me.oskarscot.joblistingsite.listing;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

  private final JobListingRepository repository;

  @Autowired
  public JobListingController(JobListingRepository repository) {
    this.repository = repository;
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<JobListing>> getAll() {
    final List<JobListing> allListings = repository.findAll();
    if(allListings.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(
        allListings
    );
  }

  @GetMapping(path = "{id}", produces = "application/json")
  public ResponseEntity<JobListing> getById(@PathVariable("id") String id) {
    return ResponseEntity.of(repository.findById(id));
  }

  @PostMapping
  public void addNewListing(@RequestBody JobListing listing){
    repository.save(listing);
  }

  @DeleteMapping(path = "{listingId}")
  public ResponseEntity<JobListing> deleteListing(@PathVariable("listingId") String id){
    final Optional<JobListing> listingOptional = repository.findById(id);
    if(listingOptional.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

}
