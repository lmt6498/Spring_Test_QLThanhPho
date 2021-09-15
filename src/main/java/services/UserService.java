package services;

import models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.IUserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepo iUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepo.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(appUser.getRole());

        UserDetails userDetails = new User(
                appUser.getUsername(),
                appUser.getPassword(),
                authorities
        );

        return userDetails ;
    }
}
