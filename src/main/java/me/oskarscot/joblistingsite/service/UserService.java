package me.oskarscot.joblistingsite.service;

import me.oskarscot.joblistingsite.model.RegistrationData;
import me.oskarscot.joblistingsite.model.User;
import me.oskarscot.joblistingsite.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final VerificationTokenService verificationTokenService;

  @Autowired
  public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, VerificationTokenService verificationTokenService) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
    this.verificationTokenService = verificationTokenService;
  }

  public void registerUser(RegistrationData data){
    final User user = new User();
    BeanUtils.copyProperties(data, user);
    user.setPassword(passwordEncoder.encode(data.getPassword()));
    userRepository.save(user);
    this.verificationTokenService.generateToken(user.getId());
  }

  public boolean userExists(String email){
    return userRepository.findByEmail(email).isPresent();
  }

}
