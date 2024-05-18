package springrestAPI.springrestAPI.auth.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springrestAPI.springrestAPI.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import springrestAPI.springrestAPI.auth.repository.UserRepository;

@Service
public class PrincipalDetailsSerivce implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username : " + username);
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        } else {
            return null;
        }
    }
}
