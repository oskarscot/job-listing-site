package me.oskarscot.joblistingsite.controller;

import me.oskarscot.joblistingsite.model.RegistrationData;
import me.oskarscot.joblistingsite.model.User;
import me.oskarscot.joblistingsite.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  @Autowired
  public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @PostMapping(path = "/register")
  public ResponseEntity<User> registerUser(@RequestBody RegistrationData data){
    if(this.userRepository.findByEmail(data.getEmail()).isPresent()){
      return ResponseEntity.badRequest().build();
    }
    final User user = new User();
    BeanUtils.copyProperties(data, user);
    user.setPassword(passwordEncoder.encode(data.getPassword()));
    this.userRepository.save(user);
    return ResponseEntity.accepted().body(user);
  }

}
