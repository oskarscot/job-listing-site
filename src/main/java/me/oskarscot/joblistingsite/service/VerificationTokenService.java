package me.oskarscot.joblistingsite.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import me.oskarscot.joblistingsite.model.VerificationToken;
import me.oskarscot.joblistingsite.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService {

  private VerificationTokenRepository verificationTokenRepository;

  @Autowired
  public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
    this.verificationTokenRepository = verificationTokenRepository;
  }

  public Optional<VerificationToken> getVerificationToken(UUID tokenID) {
    return verificationTokenRepository.findByToken(tokenID);
  }

  public boolean isValid(UUID token){
    final Optional<VerificationToken> tokenOptional = this.verificationTokenRepository.findByToken(token);
    if(tokenOptional.isEmpty()){
      return false;
    }
    return tokenOptional.get().getExpiry().isAfter(Instant.now());
  }

  public VerificationToken getTokenForUser(String userID){
    return verificationTokenRepository.findByUserID(userID);
  }

  public void generateToken(String userID){
    final VerificationToken token = new VerificationToken(UUID.randomUUID(), userID);
    //TODO send email with token

    System.out.println("Sending email with token: " + token.getToken());

    verificationTokenRepository.save(token);
  }

  public void deleteToken(UUID token){
    verificationTokenRepository.deleteByToken(token);
  }

}
