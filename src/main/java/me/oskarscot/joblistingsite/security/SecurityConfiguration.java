package me.oskarscot.joblistingsite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(6);
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer(){
    return web -> web.ignoring().antMatchers("/api/v1/user/register", "/api/v1/listing"); //temporary config
  }

}
