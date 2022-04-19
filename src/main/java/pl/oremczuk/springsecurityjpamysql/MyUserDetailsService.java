package pl.oremczuk.springsecurityjpamysql;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.oremczuk.springsecurityjpamysql.models.MyUserDetails;
import pl.oremczuk.springsecurityjpamysql.models.User;
import pl.oremczuk.springsecurityjpamysql.repositories.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        return user.map(MyUserDetails::new).get();
    }
}
