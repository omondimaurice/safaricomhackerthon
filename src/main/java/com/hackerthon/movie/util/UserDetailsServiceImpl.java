package com.hackerthon.movie.util;

import com.hackerthon.movie.Entity.ApplicationUser;
import com.hackerthon.movie.Repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ViewerRepository viewerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = viewerRepository.findApplicationUserByUsername(username).get();

        if (user == null ) {
            throw new UsernameNotFoundException("User with username " + username + "not found");
        }

        return new UserDetailsImpl(user);
    }
}
