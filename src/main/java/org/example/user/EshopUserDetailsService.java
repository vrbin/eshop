package org.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.HashSet;
@Service
public class EshopUserDetailsService implements UserDetailsService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Neznamy uzivatel.");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoles()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), true, true, true, true,
                authorities);
    }

}
