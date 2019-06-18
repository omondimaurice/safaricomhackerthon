package com.hackerthon.movie.util;

import com.hackerthon.movie.Entity.ApplicationUser;
import com.hackerthon.movie.Repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class IntialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetUp = false;


    @Autowired
    private ViewerRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetUp) {
            return;
        }

        ApplicationUser user = new ApplicationUser();
        user.setPassword(bCryptPasswordEncoder.encode("password"));
        user.setUsername("john");
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setCreatedOn(new Date(System.currentTimeMillis()));


        userRepository.save(user);

        alreadySetUp = true;
    }

}
