package me.oskarscot.joblistingsite.controller;

import me.oskarscot.joblistingsite.model.RegistrationData;
import me.oskarscot.joblistingsite.model.User;
import me.oskarscot.joblistingsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/register")
  public ResponseEntity<User> registerUser(@RequestBody RegistrationData data){
    if(this.userService.userExists(data.getEmail())){
      return ResponseEntity.badRequest().build();
    }
    this.userService.registerUser(data);
    return ResponseEntity.accepted().build();
  }


}
