package lk.ijse.springsecurityjwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/22/2021
 **/

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("nipun", "nipun", new ArrayList<>());
    }

}
