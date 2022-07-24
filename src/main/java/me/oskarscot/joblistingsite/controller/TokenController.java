package me.oskarscot.joblistingsite.controller;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import me.oskarscot.joblistingsite.model.VerificationToken;
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

  @Autowired
  public TokenController(VerificationTokenService tokenService) {
    this.tokenService = tokenService;
  }

  @GetMapping(path = "/validate/{token}", produces = "application/json")
  public boolean getToken(@PathVariable("token") UUID token) {
    final Optional<VerificationToken> tokenOptional = this.tokenService.getVerificationToken(token);
    if(tokenOptional.isEmpty()) {
      return false;
    }
    final VerificationToken verificationToken = tokenOptional.get();
    this.tokenService.deleteToken(token);
    return !verificationToken.getExpiry().isAfter(Instant.now());
  }

}
