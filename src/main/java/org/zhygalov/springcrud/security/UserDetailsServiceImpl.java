package org.zhygalov.springcrud.security;

import java.util.Set;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final Map<String, UserDetails> userStore = 
		Map.of("user", new UserDetailsImpl(1L, "user", "password", Set.of(new Role(1L, "ROLE_USER"))),
				"admin",  new UserDetailsImpl(2L, "admin", "adminPass", Set.of(new Role(2L, "ROLE_ADMIN"))));

    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userStore.get(s);
    }
}
