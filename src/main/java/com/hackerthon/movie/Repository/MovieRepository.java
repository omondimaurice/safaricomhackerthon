package com.hackerthon.movie.Repository;

import com.hackerthon.movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<List<Movie>> findMoviesByWatched(String watched);
}
