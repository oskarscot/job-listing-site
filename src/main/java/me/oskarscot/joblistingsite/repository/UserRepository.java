package me.oskarscot.joblistingsite.repository;

import java.util.Optional;
import me.oskarscot.joblistingsite.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findById(String id);
  Optional<User> findByEmail(String email);

}
