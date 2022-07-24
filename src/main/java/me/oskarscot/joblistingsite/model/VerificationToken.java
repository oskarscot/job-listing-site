package me.oskarscot.joblistingsite.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "verification_tokens")
public class VerificationToken {

  @Id
  private String id;
  private UUID token;
  private String userID;
  private Instant expiry;

  public VerificationToken(String id, UUID token, String userID, Instant expiry) {
    this.id = id;
    this.token = token;
    this.userID = userID;
    this.expiry = expiry;
  }

  public VerificationToken(UUID token, String userID) {
    this.token = token;
    this.userID = userID;
    this.expiry = Instant.now().plus(1, ChronoUnit.DAYS);
  }

  public VerificationToken(){ }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UUID getToken() {
    return token;
  }

  public void setToken(UUID token) {
    this.token = token;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public Instant getExpiry() {
    return expiry;
  }
}
