package me.oskarscot.joblistingsite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Listing not found")
public class ListingNotFoundException extends RuntimeException {

  public ListingNotFoundException(String message) {
    super(message);
  }

}
