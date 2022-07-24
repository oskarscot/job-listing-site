package me.oskarscot.joblistingsite.repository;

import java.util.Optional;
import java.util.UUID;
import me.oskarscot.joblistingsite.model.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String> {

  VerificationToken findByUserID(String userID);
  Optional<VerificationToken> findByToken(UUID token);
  void deleteByToken(UUID token);

}
