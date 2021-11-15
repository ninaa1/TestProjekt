package net.codejava;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
