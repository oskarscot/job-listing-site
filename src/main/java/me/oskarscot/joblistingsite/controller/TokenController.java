package me.oskarscot.joblistingsite.controller;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import me.oskarscot.joblistingsite.model.VerificationToken;
import me.oskarscot.joblistingsite.service.UserService;
import me.oskarscot.joblistingsite.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

  public VerificationTokenService tokenService;
  public UserService userService;

  @Autowired
  public TokenController(VerificationTokenService tokenService, UserService userService) {
    this.tokenService = tokenService;
    this.userService = userService;
  }

  @GetMapping(path = "/validate/{token}", produces = "application/json")
  public boolean getToken(@PathVariable("token") UUID token) {
    final Optional<VerificationToken> tokenOptional = this.tokenService.getVerificationToken(token);
    if(tokenOptional.isEmpty()) {
      return false;
    }
    final VerificationToken verificationToken = tokenOptional.get();

    final boolean expired = !verificationToken.getExpiry().isAfter(Instant.now());
    if(expired){
      //Delete user by ID;
    }
    this.tokenService.deleteToken(token);
    return expired;
  }

}
