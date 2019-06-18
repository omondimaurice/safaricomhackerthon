package com.hackerthon.movie.Repository;

import com.hackerthon.movie.Entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ViewerRepository extends JpaRepository<ApplicationUser,Long> {
    Optional<ApplicationUser> findApplicationUserByUsername(String username);

}
