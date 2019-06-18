package com.hackerthon.movie.service;

import com.hackerthon.movie.Entity.ApplicationUser;
import com.hackerthon.movie.Models.RegisterUser;
import com.hackerthon.movie.Repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationUserService {

    @Autowired
    private ViewerRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUser addUsers(RegisterUser user){


        ApplicationUser user1 = new ApplicationUser();
        user1.setUsername(user.getUsername());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setEmail(user.getEmail());
        user1.setEnabled(true);
        return userRepository.save(user1);
    }

    public List<ApplicationUser> getUsers(){
        return userRepository.findAll();
    }

    public Optional<ApplicationUser> getUser(Long userId){
        return userRepository.findById(userId);
    }

}
